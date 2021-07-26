package find.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class FindCloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(FindCloudGatewayApplication.class, args);
	}
}
