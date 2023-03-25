package com.carlease.customer.api;

import com.carlease.customer.entity.Customer;
import com.carlease.customer.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.carlease.customer")
@EntityScan("com.carlease.customer")
public class CustomerApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerApiApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      Customer one = new Customer();
      one.setName("Justin");
      repository.save(one);
    };
  }
}
