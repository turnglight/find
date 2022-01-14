package find.cloud.gateway;

import find.cloud.gateway.model.SysParameterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author turnglight
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(value = {SysParameterConfig.class})
public class FindCloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(FindCloudGatewayApplication.class, args);
	}
}
