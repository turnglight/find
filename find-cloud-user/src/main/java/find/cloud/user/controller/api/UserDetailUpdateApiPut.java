package find.cloud.user.controller.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
public class UserDetailUpdateApiPut {
    @NotNull
    private Long id;
    /**
     * 头像
     */
    private String via;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 年龄
     */
    @Min(value = 12, message = "年龄最小值为12岁")
    @Max(value = 100, message = "年龄最大值为100岁")
    private Integer age;
    /**
     * 身高
     */
    @Min(value = 100, message = "身高最小值为100CM")
    @Max(value = 300, message = "身高最大值为300CM")
    private Integer height;
    /**
     * 体重
     */
    @Min(value = 20, message = "体重最小值为20")
    @Max(value = 300, message = "体重最大值为300")
    private Integer weight;
    /**
     * 爱好
     */
    @NotNull(message = "教育程度不能为空")
    private String hobby;
    /**
     * 专业
     */
    private String profession;
    /**
     * 教育程度
     */
    @NotNull(message = "教育程度不能为空")
    private String edu;
    /**
     * 是否抽烟
     */
    @Min(value = 0, message = "是否抽烟设置异常")
    private Integer smoking;
    /**
     * 是否饮酒
     */
    @Min(value = 0, message = "是否饮酒设置异常")
    private Integer drink;
    /**
     * 所在地区
     */
    @NotNull(message = "地区不能为空")
    private String region;
    /**
     * 学校
     */
    private String school;
    /**
     * 学年
     */
    private String schoolYear;
    /**
     * 职业
     */
    private String career;
    /**
     * 语音
     */
    private String voice;
    /**
     * 视频
     */
    private String video;
    /**
     * 照片
     */
    private String photos;
}
