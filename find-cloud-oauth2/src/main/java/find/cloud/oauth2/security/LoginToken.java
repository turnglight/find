package find.cloud.oauth2.security;

/**
 * @author 01407975
 * @description 登录令牌实体
 * @date 2022/1/5
 */
public class LoginToken {

    private String accessToken;

    private String refreshToken;

    public LoginToken(String accessToken, String refreshToken){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
