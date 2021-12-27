package find.cloud.gateway.r2dbc;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.ZoneId;

/**
 * @author 01407975
 * @description R2DBC连接配置
 * @date 2021/12/27
 */
@Configuration
public class ConnectionFactoryConfiguration {

    @Value("${spring.r2dbc.host}")
    private String host;
    @Value("${spring.r2dbc.port}")
    private Integer port;
    @Value("${spring.r2dbc.username}")
    private String username;
    @Value("${spring.r2dbc.password}")
    private String password;
    @Value("${spring.r2dbc.database}")
    private String database;

    @Bean
    public ConnectionFactory connectionFactory() {
        return MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(database)
                .serverZoneId(ZoneId.of("UTC"))
                .build());
    }
}
