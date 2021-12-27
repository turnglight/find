package find.cloud.user.controller.api;

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
    @NotNull(message = "旧密码不能为空")
    private String oldPasswd;

    /**
     * 新密码
     */
    @NotNull(message = "新密码不能为空")
    private String newPasswd;
}
