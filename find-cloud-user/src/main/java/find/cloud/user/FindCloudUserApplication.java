package find.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("find.cloud.**.repository")
@EnableDiscoveryClient
public class FindCloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCloudUserApplication.class, args);
	}

}
