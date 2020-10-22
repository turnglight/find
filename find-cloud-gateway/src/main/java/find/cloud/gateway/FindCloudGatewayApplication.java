package find.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FindCloudGatewayApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(FindCloudGatewayApplication.class, args);
		String userName = configurableApplicationContext.getEnvironment().getProperty("user.name");
		String userAge = configurableApplicationContext.getEnvironment().getProperty("user.age");
		System.err.println("user name :"+userName+"; age: "+userAge);
	}

}
