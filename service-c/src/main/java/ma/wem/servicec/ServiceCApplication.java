package ma.wem.servicec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceCApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCApplication.class, args);
	}

}
