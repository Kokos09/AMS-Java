package com.AMS.serviceshoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceShoppingcartApplication.class, args);
	}

}
