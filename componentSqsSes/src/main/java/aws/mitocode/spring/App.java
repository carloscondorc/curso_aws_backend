package aws.mitocode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public AmazonSimpleEmailService crearSES() {
		AmazonSimpleEmailService clienteSES = new AmazonSimpleEmailServiceClient( new DefaultAWSCredentialsProviderChain() );
		clienteSES.setRegion(Region.getRegion(Regions.US_EAST_1));
		return clienteSES;
	}
}
