package find.cloud.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ali")
public class AliProperties {

    private String accessKeyID;

    private String accessKeySecret;
}
