package com.carlease.lease.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaseServiceApplication.class, args);
	}

}
