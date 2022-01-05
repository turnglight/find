package find.cloud.oauth2.security;

import base.commons.response.ResponseResult;
import base.commons.utils.ResponseUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 01407975
 * @description 未授权统一处理
 * @date 2022/1/5
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtils.renderJson(response, JSONObject.toJSONString(ResponseResult.forbidden()));
    }
}
