package find.cloud.user.hanlder;

import find.cloud.type.response.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 01407975
 * @description 全局异常拦截器
 * @date 2021/12/9
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseResult.error(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    ResponseResult handleException(RuntimeException e){
        return ResponseResult.error(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseResult handleException(Exception e){
        LOGGER.error(e.getMessage(), e);
        return ResponseResult.error("操作失败");
    }
}
