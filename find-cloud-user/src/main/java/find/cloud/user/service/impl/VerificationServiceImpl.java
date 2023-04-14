package find.cloud.user.service.impl;


import base.web.utils.HttpClient4Utils;
import com.alibaba.fastjson.JSONObject;
import find.cloud.user.config.JiguangProperties;
import find.cloud.user.service.VerificationService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    private JiguangProperties jiguangProperties;
    /**
     * 实例化HttpClient，发送http请求使用，可根据需要自行调参
     */
    private static HttpClient httpClient = HttpClient4Utils.createHttpClient(100, 20, 10000, 2000, 2000);

    @Override
    public String loginTokenVerify(String loginToken) {
        // 登录TOKEN认证
        return this.postLoginTokenVerify(loginToken);
    }

    private String postLoginTokenVerify(String loginToken){
        Map<String,String> params = new HashMap<>();
        params.put("loginToken", loginToken);
        params.put("exID", jiguangProperties.getExId());


        String base64Appkey = Base64.getEncoder().encode(jiguangProperties.getAppKey().getBytes(StandardCharsets.UTF_8)).toString();
        String base64MasterSecret = Base64.getEncoder().encode(jiguangProperties.getMasterSecret().getBytes(StandardCharsets.UTF_8)).toString();
        StringBuilder headerBuilder = new StringBuilder().append("Basic ")
                .append(base64Appkey)
                .append(":")
                .append(base64MasterSecret);
        Header header = new BasicHeader("Authorization", headerBuilder.toString());

        String postUrl = jiguangProperties.getLoginTokenVerifyUrl();
        String result = HttpClient4Utils.sendPost(httpClient, postUrl, params, Consts.UTF_8, header);
        log.info("JVerification:{}", result);

        TokenVerifyVo tokenVerifyVo = JSONObject.parseObject(result, TokenVerifyVo.class);
        if(tokenVerifyVo.getCode().intValue() == 8000){
            try {
                return decrypt(tokenVerifyVo.getPhone(), jiguangProperties.getPrivateKey());
            } catch (Exception e) {
                throw new RuntimeException("认证失败！");
            }
        }
        return "";
    }

    public static String decrypt(String cryptograph, String prikey) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(prikey));
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);

        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte [] b = Base64.getDecoder().decode(cryptograph);
        return new String(cipher.doFinal(b));
    }
}

@Data
class TokenVerifyVo{
    /**
     * 流水号，请求出错时可能为空
     */
    private Long id;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回码说明
     */
    private String content;
    /**
     * 开发者自定义的id，若请求时为空返回为空
     */
    private String exID;
    /**
     * 加密后的手机号码，需用配置在极光的公钥对应的私钥解密
     */
    private String phone;
}
