package find.cloud.gateway.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 * 令牌的配置
 *
 * @author  turnglight
 */
@Configuration
public class RedisAccessTokenConfig {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }
}
