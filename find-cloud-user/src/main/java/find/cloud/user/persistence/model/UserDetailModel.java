package find.cloud.user.persistence.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @description
 * @author turnglight
 * @date  2021-11-30
 */
@Data
@TableName(value = "user_detail")
public class UserDetailModel implements Serializable {
    private static final long serialVersionUID = -2952735933715107252L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String sno;
    private String via;
    private String idNumber;
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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
