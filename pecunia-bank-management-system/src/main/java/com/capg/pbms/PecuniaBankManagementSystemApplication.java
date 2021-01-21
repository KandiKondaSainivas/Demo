package com.capg.pbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PecuniaBankManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankManagementSystemApplication.class, args);
	}
	
	

}
