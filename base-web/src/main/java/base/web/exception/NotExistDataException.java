package base.web.exception;

/**
 * @author 01407975
 * @description 数据不存在异常
 * @date 2021/12/9
 */
public class NotExistDataException  extends RuntimeException {

    public NotExistDataException() {
        super();
    }

    public NotExistDataException(String message) {
        super(message);
    }

    public NotExistDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistDataException(Throwable cause) {
        super(cause);
    }

    protected NotExistDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
