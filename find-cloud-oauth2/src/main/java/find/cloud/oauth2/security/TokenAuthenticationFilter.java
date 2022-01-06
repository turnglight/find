package find.cloud.oauth2.security;

import com.alibaba.fastjson.JSONObject;
import find.cloud.oauth2.service.impl.JwtTokenUserDetailsService;
import find.cloud.oauth2.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 01407975
 * @description Token验证过滤器
 * @date 2022/1/5
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Qualifier("jwtTokenUserDetailsService")
    @Autowired
    private UserDetailsService jwtTokenUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("authentication");
        if(!StringUtils.isEmpty(token)){
            String username = JwtTokenUtil.getUsernameByToken(token);
            if(!StringUtils.isEmpty(username) && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = jwtTokenUserDetailsService.loadUserByUsername(username);
                if(username.equals(userDetails.getUsername())){
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
