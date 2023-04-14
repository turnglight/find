package find.cloud.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jiguang.api")
public class JiguangProperties {

    private String appKey;

    private String masterSecret;

    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 登录认证URL
     */
    private String loginTokenVerifyUrl;
    /**
     * 号码认证URL
     */
    private String verifyUrl;

    private String exId;
}
