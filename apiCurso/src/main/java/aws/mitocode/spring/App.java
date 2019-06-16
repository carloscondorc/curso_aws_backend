package aws.mitocode.spring;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import aws.mitocode.spring.SecurityConfiguration;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@Import({SwaggerConfig.class, SecurityConfiguration.class})
public class App {

	//@Value("${restful.timeout}")
	//private int timeout;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
/*
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate(getClientHttpRequestFactory());
		template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return template;
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		RequestConfig config = RequestConfig
				.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		
		CloseableHttpClient client = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}*/
}
