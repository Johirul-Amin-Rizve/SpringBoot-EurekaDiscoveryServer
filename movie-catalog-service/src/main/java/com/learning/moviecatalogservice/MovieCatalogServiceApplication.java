package com.learning.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {

	//rest template request
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	//webclient request
//	@Bean
//	public WebClient.Builder getWebclientBuilder(){
//		return WebClient.builder();
//	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
