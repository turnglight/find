package find.cloud.user.controller.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 01407975
 * @description 登录参数
 * @date 2021/12/27
 */
@Data
public class UserLoginApiPost {
    @NotNull
    private String phone;
    @NotNull
    private String password;
}
