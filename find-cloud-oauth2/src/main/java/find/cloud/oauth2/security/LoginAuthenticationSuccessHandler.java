package find.cloud.oauth2.security;

import base.commons.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import find.cloud.oauth2.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 01407975
 * @description 登录认证成功Handler
 * @date 2022/1/5
 */
@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JSONObject subject = new JSONObject();
        subject.put("username", userDetails.getUsername());
        // 生成令牌
        String accessToken = JwtTokenUtil.createToken(userDetails.getUsername(), 3600L);
        // 生成刷新令牌，如果accessToken，则通过refreshToken重新获取令牌
        String refreshToken = JwtTokenUtil.createToken(userDetails.getUsername(), 24 * 3600L);
        renderToken(response, new LoginToken(accessToken, refreshToken));
    }

    public void renderToken(HttpServletResponse response, LoginToken loginToken){
        ResponseUtils.renderJson(response, JSONObject.toJSONString(ResponseResult.ok(loginToken)));
    }
}
