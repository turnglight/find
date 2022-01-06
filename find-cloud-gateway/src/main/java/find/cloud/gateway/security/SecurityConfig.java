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
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
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

    public static final String[] AUTH_WHITELIST = new String[]{"/find-cloud-oauth2/login", "/logout"};

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(authenticationManager);
        authenticationWebFilter.setServerAuthenticationConverter(new ServerBearerTokenAuthenticationConverter());
         http.httpBasic().disable()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(AUTH_WHITELIST).permitAll()
//                // 访问权限控制
                .anyExchange().access(authorizeConfigManager)
                .and().exceptionHandling()
                .accessDeniedHandler(requestAccessDeniedHandler)
                // 无访问权限handler
                .authenticationEntryPoint(requestAuthenticationEntryPoint)
                .and()
//                .addFilterAt(corsFilter, SecurityWebFiltersOrder.CORS)
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .logout()
                // 登出成功handler
                .logoutSuccessHandler(logoutSuccessHandler);
        return http.build();
    }
}
