package find.cloud.oauth2.security;

import find.cloud.oauth2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String)authentication.getCredentials();
        if(StringUtils.isEmpty(name)){
            throw new UsernameNotFoundException("用户名不可以为空");
        }
        if(StringUtils.isEmpty(password)){
            throw new BadCredentialsException("密码不可以为空");
        }
        SecurityUser user = loginService.loadByUsername(name);
        if(user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if(passwordEncoder.matches(password, user.getPassword())){
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, password, null);
            auth.setDetails(auth);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return auth;
        }else{
            throw new BadCredentialsException("密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("888888"));
        System.out.println(passwordEncoder.matches("1234", "$2a$10$iMzuKG/OEma9Suz6n7I2bu2KiX/Uvx6AGSfkLhaCl5Xs36rJMufpi"));
    }
}
