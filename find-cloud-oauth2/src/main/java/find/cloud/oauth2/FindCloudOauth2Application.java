package find.cloud.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FindCloudOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(FindCloudOauth2Application.class, args);
    }

}
