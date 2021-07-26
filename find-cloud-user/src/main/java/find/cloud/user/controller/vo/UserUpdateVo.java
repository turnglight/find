package find.cloud.user.controller.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateVo {

    @NotNull
    @Min(value = 1, message = "用户标识异常")
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 职业
     */
    private String profession;

    /**
     * 教育程度
     */
    private String edu;

    /**
     * 是否抽烟
     */
    private Integer smoking;

    /**
     * 是否饮酒
     */
    private Integer drink;

    /**
     * 所在地区
     */
    private String region;

    /**
     * 微信号
     */
    private String wxno;

    /**
     * 电话号码
     */
    private String phone;
}
