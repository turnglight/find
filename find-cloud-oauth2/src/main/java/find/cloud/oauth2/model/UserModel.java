package find.cloud.oauth2.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Entity(name = "user")
public class UserModel implements Serializable {
  private static final long serialVersionUID = -2952735933715107252L;
  @Id
  @GeneratedValue
  private Long id;
  private String sno;
  private String name;
  private String nickname;
  private String password;
  private Integer status;
  private Integer level;
  private Integer vipState;
  private Integer onlineStatus;
  private String phone;
  private String wxno;
  private LocalDateTime lastLoginTime;
  @CreatedDate
  private LocalDateTime createTime;
  @UpdateTimestamp
  private LocalDateTime updateTime;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getVipState() {
    return vipState;
  }

  public void setVipState(Integer vipState) {
    this.vipState = vipState;
  }

  public Integer getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(Integer onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWxno() {
    return wxno;
  }

  public void setWxno(String wxno) {
    this.wxno = wxno;
  }

  public LocalDateTime getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(LocalDateTime lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }
}
