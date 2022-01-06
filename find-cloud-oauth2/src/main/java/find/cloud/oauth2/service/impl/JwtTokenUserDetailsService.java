package find.cloud.oauth2.service.impl;

import find.cloud.oauth2.security.SecurityUser;
import find.cloud.oauth2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author 01407975
 * @description 查询用户详细信息
 * @date 2022/1/5
 */
@Service
public class JwtTokenUserDetailsService implements UserDetailsService {

    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = loginService.loadByUsername(username);
        return securityUser;
    }
}
