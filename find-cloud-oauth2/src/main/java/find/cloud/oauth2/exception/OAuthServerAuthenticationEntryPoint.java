package find.cloud.oauth2.exception;

import base.commons.response.HttpStatus;
import base.commons.response.ResponseResult;
import find.cloud.oauth2.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author turnglight
 *
 * 用于处理客户端想认证出错，包括客户端id、密码错误
 */
@Component
@Slf4j
public class OAuthServerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * 认证失败处理器会调用这个方法返回提示信息
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ResponseUtils.result(response, ResponseResult.forbidden());
    }
}
