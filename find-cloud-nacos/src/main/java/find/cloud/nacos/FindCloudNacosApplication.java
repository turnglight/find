package find.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FindCloudNacosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(FindCloudNacosApplication.class, args);
		String env = configurableApplicationContext.getEnvironment().getProperty("current.env");
		System.err.println(env);
	}

}
