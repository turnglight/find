package find.cloud.user.persistence.model;

import com.baomidou.mybatisplus.annotation.*;
import find.cloud.user.domain.enums.UserOnlineStatus;
import find.cloud.user.domain.enums.UserStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@Data
@TableName(value = "user")
public class UserModel implements Serializable {
  private static final long serialVersionUID = -2952735933715107252L;
  @TableId(type = IdType.AUTO)
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
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
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
