package find.cloud.gateway.security;

import find.cloud.gateway.security.impl.ReactiveUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author turnglight
 * @description 认证管理器
 * @date 2021/12/27
 */
@Component
public class AuthenticationManager extends AbstractUserDetailsReactiveAuthenticationManager {

    private Scheduler scheduler = Schedulers.boundedElastic();

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private ReactiveUserDetailsServiceImpl ReactiveUserDetailsService;


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String newPassword = passwordEncoder.encode("123");
        System.out.println(newPassword);
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        AuthenticationToken token = (AuthenticationToken) authentication;
        final String username = authentication.getName();
        final String presentedPassword = (String) authentication.getCredentials();
        final String tenant = token.getTenant();
        final String host = token.getHost();
        Mono<UserDetails> userDetailsMono = retrieveUser(username);
        return userDetailsMono.publishOn(scheduler)
                .filter(u -> passwordEncoder.matches(presentedPassword, u.getPassword()))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BadCredentialsException("Invalid Credentials"))))
                .flatMap(u -> {
                    boolean upgradeEncoding = ReactiveUserDetailsService != null
                            && passwordEncoder.upgradeEncoding(u.getPassword());
                    if (upgradeEncoding) {
                        String newPassword = passwordEncoder.encode(presentedPassword);
                        return ReactiveUserDetailsService.updatePassword(u, newPassword);
                    }
                    return Mono.just(u);
                })
                .flatMap(userDetails -> {
                    // 省略业务代码
                    return Mono.just(userDetails);
                })
                .map(u -> new AuthenticationToken(u, u.getPassword(), u.getAuthorities()));
    }

    @Override
    protected Mono<UserDetails> retrieveUser(String username) {
        return ReactiveUserDetailsService.findByUsername(username);
    }
}
