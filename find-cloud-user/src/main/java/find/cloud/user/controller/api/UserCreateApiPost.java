package find.cloud.user.controller.api;

import lombok.Data;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
public class UserCreateApiPost {
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 微信号
     */
    private String wxno;
}
