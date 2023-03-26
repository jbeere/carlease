package com.carlease.car.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.carlease.car")
@EntityScan("com.carlease.car")
public class CarServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarServiceApplication.class, args);
  }

}
