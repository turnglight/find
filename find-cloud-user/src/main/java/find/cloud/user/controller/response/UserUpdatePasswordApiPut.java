package find.cloud.user.controller.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
public class UserUpdatePasswordApiPut {
    @NotNull
    private Long id;
    /**
     * 旧密码
     */
    @NotNull(message = "旧密码")
    private String oldPasswd;

    /**
     * 新密码
     */
    @NotNull(message = "新密码")
    private String newPasswd;
}
