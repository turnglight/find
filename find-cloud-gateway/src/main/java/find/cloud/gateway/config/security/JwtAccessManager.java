package find.cloud.gateway.config.security;

import cn.hutool.core.convert.Convert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * 鉴权管理器 用于认证成功之后对用户的权限进行鉴权
 * TODO 此处的逻辑：从redis中获取对应的uri的权限，与当前用户的token的携带的权限进行对比，如果包含则鉴权成功
 *      企业中可能有不同的处理逻辑，可以根据业务需求更改鉴权的逻辑
 * @author turnglight
 */
@Slf4j
@Component
public class JwtAccessManager implements ReactiveAuthorizationManager<AuthorizationContext> {

//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        //从Redis中获取当前路径可访问角色列表
        URI uri = authorizationContext.getExchange().getRequest().getURI();
////        Object value = redisTemplate.opsForHash().get(SysConstant.OAUTH_URLS, uri.getPath());
        List<String> authorities = Convert.toList(String.class,"");
//        //认证通过且角色匹配的用户可访问当前路径
//        return mono
//                //判断是否认证成功
//                .filter(Authentication::isAuthenticated)
//                //获取认证后的全部权限
//                .flatMapIterable(Authentication::getAuthorities)
//                .map(GrantedAuthority::getAuthority)
//                //如果权限包含则判断为true
//                .any(authorities::contains)
//                .map(AuthorizationDecision::new)
//                .defaultIfEmpty(new AuthorizationDecision(true));
        return Mono.just(new AuthorizationDecision(true));
    }

}
