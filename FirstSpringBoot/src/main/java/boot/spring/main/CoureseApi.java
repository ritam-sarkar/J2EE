package boot.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"boot.spring"})
public class CoureseApi {

	public static void main(String[] args) {

		SpringApplication.run(CoureseApi.class, args);
	}
	

}
