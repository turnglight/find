package find.cloud.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

import java.util.LinkedList;

/**
 * @author turnglight
 * @description 安全认证配置
 * @date 2021/12/27
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;
    @Autowired
    private RequestAccessDeniedHandler requestAccessDeniedHandler;
    @Autowired
    private RequestAuthenticationEntryPoint requestAuthenticationEntryPoint;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private AuthenticationManager authenticationManager;

    private static final String[] AUTH_WHITELIST = new String[]{"/login", "/logout"};

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
         http.httpBasic().disable()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(AUTH_WHITELIST).permitAll()
                // 访问权限控制
                .anyExchange().access(authorizeConfigManager)
                .and().exceptionHandling()
                .accessDeniedHandler(requestAccessDeniedHandler)
                // 无访问权限handler
                .authenticationEntryPoint(requestAuthenticationEntryPoint)
                .and()
//                .addFilterAt(corsFilter, SecurityWebFiltersOrder.CORS)
                .addFilterAt(new AuthenticationWebFilter(reactiveAuthenticationManager()), SecurityWebFiltersOrder.AUTHENTICATION)
                .logout()
                // 登出成功handler
                .logoutSuccessHandler(logoutSuccessHandler);
        return http.build();
    }

    /**
     * 注册用户信息验证管理器，可按需求添加多个按顺序执行
     * @return
     */
    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
        managers.add(authenticationManager);
        return new DelegatingReactiveAuthenticationManager(managers);
    }


    /**
     * BCrypt密码编码
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
