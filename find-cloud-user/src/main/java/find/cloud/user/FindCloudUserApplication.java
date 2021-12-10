package find.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@SpringBootApplication
@EnableJpaRepositories("find.cloud.user.persistence.mapper")
@EnableJpaAuditing
@EnableDiscoveryClient
public class FindCloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCloudUserApplication.class, args);
	}

}
