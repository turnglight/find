package find.cloud.user.persistence.model;

import find.cloud.user.type.UserOnlineStatus;
import find.cloud.user.type.UserStatus;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
@Entity(name = "user")
@EntityListeners(AuditingEntityListener.class)
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
  @LastModifiedDate
  private LocalDateTime updateTime;

  public UserModel(){
    this.sno = "";
    this.name = "";
    this.nickname = "";
    this.password = "";
    this.status = UserStatus.INITIALIZE.getCode();
    this.level = 0;
    this.vipState = 0;
    this.onlineStatus = UserOnlineStatus.INITIALIZE.getCode();
    this.phone = "";
    this.wxno = "";

  }
}
