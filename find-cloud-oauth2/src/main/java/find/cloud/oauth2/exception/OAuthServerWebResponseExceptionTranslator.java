package find.cloud.oauth2.exception;

import base.commons.response.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * @author turnglight
 *
 * 自定义异常翻译器，针对用户名、密码异常，授权类型不支持的异常进行处理
 */
@SuppressWarnings("ALL")
public class OAuthServerWebResponseExceptionTranslator implements WebResponseExceptionTranslator{
    /**
     * 业务处理方法，重写这个方法返回客户端信息
     */
    @Override
    public ResponseEntity<ResponseResult> translate(Exception e){
        ResponseResult resultMsg = doTranslateHandler(e);
        return new ResponseEntity<>(resultMsg, HttpStatus.UNAUTHORIZED);
    }

    /**
     * 根据异常定制返回信息
     */
    private ResponseResult doTranslateHandler(Exception e) {
        if(e instanceof UnsupportedGrantTypeException){
            return ResponseResult.unauthorized();
        }else if(e instanceof InvalidGrantException){
            return ResponseResult.forbidden();
        }
        return ResponseResult.unauthorized();
    }
}
