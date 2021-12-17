package find.cloud.user.domain.enums;

/**
 * @author 01407975
 * @description 用户在线状态
 * @date 2021/12/9
 */
public enum UserOnlineStatus {

    INITIALIZE (0, "初始状态"),
    OFFLINE (1, "下线"),
    ONLINE (2, "在线"),
    DND (3, "勿打扰");

    private Integer code;
    private String name;

    UserOnlineStatus(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static UserOnlineStatus getEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (UserOnlineStatus enu : UserOnlineStatus.values()) {
            if (code.equals(enu.getCode())) {
                return enu;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
