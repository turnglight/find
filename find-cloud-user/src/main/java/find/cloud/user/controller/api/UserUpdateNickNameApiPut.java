package find.cloud.user.controller.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
public class UserUpdateNickNameApiPut {
    @NotNull
    private Long id;
    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    private String name;
    /**
     * 昵称
     */
    @NotNull(message = "昵称不能为空")
    private String nickname;
}
