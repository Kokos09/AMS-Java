package com.AMS.servicearticles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceArticlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceArticlesApplication.class, args);
	}

}
