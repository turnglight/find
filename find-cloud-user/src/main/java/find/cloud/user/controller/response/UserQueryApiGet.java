package find.cloud.user.controller.response;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
public class UserQueryApiGet {
    /**
     * 名称
     */
    private String name;
    /**
     * 序列号
     */
    private String sno;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 微信号
     */
    private String wxno;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 区域
     */
    private String region;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * VIP状态
     */
    private Integer vipState;
    /**
     * VIP级别
     */
    private Integer vipLevel;
    /**
     * 排序字段
     */
    private String orderField;
    /**
     * 排序类型： ASC, DESC
     */
    private String orderType;
    /**
     * 页码
     */
    @NotNull(message = "分页参数-页码不能为空")
    @Min(value = 0, message = "分页参数必须大于0")
    private Integer pageNo;
    /**
     * 页大小
     */
    @NotNull(message = "分页参数-页大小不能为空")
    @Min(value = 1, message = "页大小必须大于1")
    @Min(value = 100, message = "页大小必须大于1")
    private Integer pageSize  = 10;
}
