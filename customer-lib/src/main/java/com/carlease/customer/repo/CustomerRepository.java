package com.carlease.customer.repo;

import org.springframework.data.repository.CrudRepository;
import com.carlease.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {



}
