package find.cloud.gateway.security;

import base.commons.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.CharsetUtil;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author turnglight
 * @description 认证异常
 * @date 2021/12/27
 */
@Component
public class AuthEntryPointException implements ServerAuthenticationEntryPoint {

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        String body = JSONObject.toJSONString(ResponseResult.error("认证异常"));
        DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));
        return exchange.getResponse().writeWith(Flux.just(wrap));
    }
}
