package aws.mitocode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

import aws.mitocode.spring.SecurityConfiguration;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@Import({SwaggerConfig.class, SecurityConfiguration.class})
public class App{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
/*	
	@Bean
	public AmazonSNSClient crearSNS() {
		AmazonSNSClient clienteSNS = new AmazonSNSClient(new DefaultAWSCredentialsProviderChain());		                           
		clienteSNS.setRegion(Region.getRegion(Regions.US_EAST_1));
		return clienteSNS;
	}*/
}
