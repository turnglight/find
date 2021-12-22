package find.cloud.user.controller.response;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author turnglight
 * @date  2021-11-30
 */
public class UserDetailUpdateApiPut {
    @NotNull
    @Min(value = 1, message = "用户标识异常")
    private Long userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public Integer getSmoking() {
        return smoking;
    }

    public void setSmoking(Integer smoking) {
        this.smoking = smoking;
    }

    public Integer getDrink() {
        return drink;
    }

    public void setDrink(Integer drink) {
        this.drink = drink;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
