package find.cloud.user.persistence.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @description
 * @author turnglight
 * @date  2021-11-30
 */
@Data
@Entity(name = "user_detail")
@EntityListeners(AuditingEntityListener.class)
public class UserDetailModel implements Serializable {
    private static final long serialVersionUID = -2952735933715107252L;
    @Id
    @GeneratedValue
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
    @CreatedDate
    private LocalDateTime createTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
}
