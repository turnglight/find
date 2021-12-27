package find.cloud.gateway.security;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author turnglight
 * @description 账号认证
 * @date 2021/12/27
 */
public interface AccountInfoRepository extends ReactiveCrudRepository<AccountInfo, Long> {

    @Query(value = "select name as username, password from user where name=:username")
    Mono<AccountInfo> findByUsername(String username);

}
