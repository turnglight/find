package find.cloud.user.domain.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author turnglight
 * @description 用户详情
 * @date 2021/12/9
 */
@Data
public class UserDetail {
    @NotNull
    private Long id;
    @NotNull
    private Long userId;
    private String idNumber;
    private String sno;
    private String via;
    private String photos;
    private String voice;
    private String video;
    private String signature;
    private Integer gender;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String hobby;
    private String edu;
    private Integer smoking;
    private Integer drink;
    private String region;
    private String school;
    private String profession;
    private String schoolYear;
    private String career;
    private String phone;
    private BigDecimal lng;
    private BigDecimal lat;
}
