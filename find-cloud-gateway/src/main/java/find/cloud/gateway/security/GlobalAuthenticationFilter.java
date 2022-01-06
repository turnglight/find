package find.cloud.gateway.security;

import base.commons.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @author 01407975
 * @description 全局认证过滤器
 * @date 2022/1/6
 */
@Component
public class GlobalAuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestUrl = exchange.getRequest().getPath().value();
        if(checkUrls(requestUrl)){
            return chain.filter(exchange);
        }
        String token = getToken(exchange);
        if(StringUtils.isEmpty(token)){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().add(org.apache.http.HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            String body = JSONObject.toJSONString(ResponseResult.error("无访问权限"));
            DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
            return response.writeWith(Mono.just(buffer));
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }


    private String getToken(ServerWebExchange exchange){
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        return httpHeaders.getFirst("anthentication");
    }

    private Boolean checkUrls(String requestUrl){
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for(String url: SecurityConfig.AUTH_WHITELIST){
            if(antPathMatcher.match(url, requestUrl)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
