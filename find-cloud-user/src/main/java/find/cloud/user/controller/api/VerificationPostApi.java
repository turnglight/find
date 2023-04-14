package find.cloud.user.controller.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VerificationPostApi {
    /**
     * 认证后返回的登录TOKEN
     */
    @NotBlank
    private String loginToken;
}
