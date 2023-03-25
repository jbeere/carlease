package com.carlease.customer.service;

import com.carlease.customer.entity.Customer;
import com.carlease.customer.repo.CustomerRepository;
import com.carlease.customer.validation.CustomerValidator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository repo;

  @Autowired
  CustomerValidator validator;

  @Override
  public Optional<Customer> findById(long customerId) {
    return repo.findById(customerId);
  }

  @Override
  public Customer create(Customer input) {
    if (input == null) {
      throw new IllegalArgumentException("new customer cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("new customer cannot have an id");
    }
    Customer valid = validateOrThrow(input);
    return repo.save(valid);
  }

  @Override
  public Optional<Customer> update(Customer input) {
    if (input == null) {
      throw new IllegalArgumentException("customer cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("customer cannot have an id");
    }
    Customer valid = validateOrThrow(input);
    if (repo.existsById(input.getId())) {
      return Optional.of(repo.save(valid));
    }
    return Optional.empty();
  }

  @Override
  public void delete(long customerId) {
    repo.deleteById(customerId);
  }

  private Customer validateOrThrow(Customer customer) {
    List<String> errors = validator.validate(customer);
    if (errors.isEmpty()) {
      return customer;
    }
    throw new InvalidCustomerException(errors);
  }
}
