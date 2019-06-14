package aws.mitocode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import aws.mitocode.spring.SecurityConfiguration;
import aws.mitocode.spring.SwaggerConfig;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@Import({SwaggerConfig.class, SecurityConfiguration.class})
public class App{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
