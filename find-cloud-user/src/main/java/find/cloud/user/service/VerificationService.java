package find.cloud.user.service;

public interface VerificationService {

    /**
     * 手机登录token认证
     * @param phone
     * @param loginToken
     * @return
     */
    String loginTokenVerify(String loginToken);
}
