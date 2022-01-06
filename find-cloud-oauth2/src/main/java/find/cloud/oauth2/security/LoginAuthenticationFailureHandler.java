package find.cloud.oauth2.security;

import base.commons.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 01407975
 * @description 登录失败操作
 * @date 2022/1/5
 */
@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(exception instanceof BadCredentialsException){
            ResponseUtils.renderJson(response, JSONObject.toJSONString(ResponseResult.ok("用户名或密码不正确")));
        }else if(exception instanceof UsernameNotFoundException){
            ResponseUtils.renderJson(response, JSONObject.toJSONString(ResponseResult.ok("用户名不存在")));
        }
        ResponseUtils.renderJson(response, JSONObject.toJSONString(ResponseResult.ok("登录失败")));
    }
}
