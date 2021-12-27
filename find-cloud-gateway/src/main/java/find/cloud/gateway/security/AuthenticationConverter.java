package find.cloud.gateway.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerFormLoginAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author turnglight
 * @description 将表单参数转换为AuthenticationToken
 * @date 2021/12/27
 */
@Component
public class AuthenticationConverter extends ServerFormLoginAuthenticationConverter {

    private String usernameParameter = "username";

    private String passwordParameter = "password";

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        MultiValueMap<String, String> multiValueMap = exchange.getRequest().getQueryParams();
        String tenant = headers.getFirst("_tenant");
        String host = headers.getHost().getHostName();
        Mono<MultiValueMap<String, String>> multiValueMapMono = exchange.getFormData();
        return multiValueMapMono.map(data -> {
                    String username = data.getFirst(this.usernameParameter);
                    String password = data.getFirst(this.passwordParameter);
                    return new AuthenticationToken(username, password, tenant, host);
                });
    }

}
