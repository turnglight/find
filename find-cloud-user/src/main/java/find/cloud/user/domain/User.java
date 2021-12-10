package find.cloud.user.domain;

import find.cloud.type.exception.NullValueException;
import find.cloud.user.type.UserOnlineStatus;
import find.cloud.user.type.UserStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author turnglight
 * @description 用户
 * @date 2021/12/9
 */
@Data
public class User {
    private Long id;
    private String sno;
    private String name;
    private String nickname;
    private Integer status;
    private Integer level;
    private Integer vipState;
    private Integer onlineStatus;
    private String phone;
    private String wxno;
    private LocalDateTime lastLoginTime;

    private Long userId;
    private String idNumber;
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
    private BigDecimal lat;
    private BigDecimal lng;

    public User(){}

    public User(String wxno, String phone){
        this("", "", UserStatus.INITIALIZE.getCode(),
                0, 0, UserOnlineStatus.INITIALIZE.getCode(),
                phone, wxno, 0L, "", "", "",
                "", "", "", 0,
                0, 0, 0, "",
                "", 0, 0, "",
                "", "", "", "");
    }

    public User(String name, String nickname, Integer status,
                Integer level, Integer vipState, Integer onlineStatus,
                String phone, String wxno, Long userId, String idNumber, String via, String photos,
                String voice, String video, String signature, Integer gender,
                Integer age, Integer height, Integer weight, String hobby,
                String edu, Integer smoking, Integer drink, String region,
                String school, String profession, String schoolYear, String career) {
        if(StringUtils.isBlank(wxno) || StringUtils.isBlank(phone)){
            throw new NullValueException();
        }
        this.sno = genarateSno();
        this.name = name;
        this.nickname = nickname;
        this.status = status;
        this.level = level;
        this.vipState = vipState;
        this.onlineStatus = onlineStatus;
        this.phone = phone;
        this.wxno = wxno;
        this.userId = userId;
        this.idNumber = idNumber;
        this.via = via;
        this.photos = photos;
        this.voice = voice;
        this.video = video;
        this.signature = signature;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hobby = hobby;
        this.edu = edu;
        this.smoking = smoking;
        this.drink = drink;
        this.region = region;
        this.school = school;
        this.profession = profession;
        this.schoolYear = schoolYear;
        this.career = career;
        this.lat = new BigDecimal(0);
        this.lng = new BigDecimal(0);
    }

    private String genarateSno(){
        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.of("+8"));
        return String.valueOf(instant.getEpochSecond());
    }
}
