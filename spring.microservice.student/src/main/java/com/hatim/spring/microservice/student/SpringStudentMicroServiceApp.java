package com.hatim.spring.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringStudentMicroServiceApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStudentMicroServiceApp.class, args);
	}
	
}
