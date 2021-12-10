package find.cloud.user.type;

/**
 * @decription 用户状态
 * @author turnglight
 * @date 2021-12-08
 */
public enum UserStatus {

    INITIALIZE (0, "初始化"),
    UNAUTH (1, "待实名认证"),
    NORMAL(2, "正常"),
    FINE(3, "正常"),
    GOOD(4, "优质"),
    EXCEPTION(10, "异常"),
    FREEZE(11, "冻结"),
    BANNED(99, "永久封号");

    private Integer code;
    private String name;

    UserStatus(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public static UserStatus getEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (UserStatus enu : UserStatus.values()) {
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
