package find.cloud.oauth2.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

/**
 * @description JWT工具类
 * @author turnglight
 */
@Component
public class JwtTokenUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "jwt_secret_turnglight";
    private static final String ISS = "turnglight";

    /**
     * 过期时间是 1800 秒
     */
    private static final long EXPIRATION = 1800L;

    public static String createToken(String username, long expiration) {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("expired", System.currentTimeMillis() + 3600 * 1000L);
        Signer signer = new MacSigner(SECRET);
        return JwtHelper.encode(JSONObject.toJSONString(json), signer).getEncoded();
    }

    /**
     * 校验是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        String claims = JwtHelper.decode(token).getClaims();
        JSONObject jsonObject = JSONObject.parseObject(claims);
        Long expired = jsonObject.getLong("expired");
        return expired > System.currentTimeMillis();
    }

    /**
     * 校验是否过期
     *
     * @param token
     * @return
     */
    public static String getUsernameByToken(String token) {
        String claims = JwtHelper.decode(token).getClaims();
        JSONObject jsonObject = JSONObject.parseObject(claims);
        return jsonObject.getString("username");
    }
//
//    public static void main(String[] args) {
////        System.out.println(createToken("123", 10L));
//
//        String result = JwtHelper.decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHBpcmVkIjoxNjQxNDYwNTc5MTU5LCJ1c2VybmFtZSI6IjEyMyJ9.VjSA5PJPeOg2tJO3J-j2rTACYuFmYqwwmhFOIUMoB00").getClaims();
//        System.out.println(result);
//    }

}
