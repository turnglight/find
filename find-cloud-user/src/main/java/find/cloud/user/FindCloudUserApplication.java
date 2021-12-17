package find.cloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author turnglight
 * @date  2021-11-30
 */
@SpringBootApplication
@MapperScan("find.cloud.user.persistence.mapper")
@EnableDiscoveryClient
public class FindCloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindCloudUserApplication.class, args);
	}

}
