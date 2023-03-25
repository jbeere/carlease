package com.carlease.customer.service;

import com.carlease.customer.entity.Customer;
import java.util.Optional;

public interface CustomerService {

  Optional<Customer> findById(long customerId);

  Customer create(Customer input);

  Optional<Customer> update(Customer input);

  void delete(long customerId);

}
