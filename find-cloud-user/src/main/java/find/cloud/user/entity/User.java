package find.cloud.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "T_USER")
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户序列号
     */
    private String sno;
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

    /**
     * 经度
     */
    private BigDecimal lng;

    /**
     * 维度
     */
    private BigDecimal lat;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户等级
     */
    private Integer level;

    /**
     * 是否VIP
     */
    private Integer vipState;

    /**
     * VIP级别
     */
    private Integer vipLevel;

    /**
     * 
     */
    private String createTime;

    /**
     * 
     */
    private String updateTime;
}