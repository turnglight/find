package find.cloud.gateway.exception;

/**
 * @author 01407975
 * @description TOKEN
 * @date 2021/12/27
 */
public class TokenException extends RuntimeException {

    public TokenException() {
        super();
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }

    protected TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
