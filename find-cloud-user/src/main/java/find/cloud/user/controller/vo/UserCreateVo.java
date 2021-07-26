package find.cloud.user.controller.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateVo {
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 微信号
     */
    private String wxno;
}
