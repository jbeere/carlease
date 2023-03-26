package com.carlease.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.carlease.customer")
@EntityScan("com.carlease.customer")
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }
}
