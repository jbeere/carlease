package com.carlease.customer.service.repo;

import org.springframework.data.repository.CrudRepository;
import com.carlease.customer.service.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {



}
