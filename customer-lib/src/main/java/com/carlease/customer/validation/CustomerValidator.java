package com.carlease.customer.validation;

import com.carlease.customer.entity.Customer;
import java.util.List;

public interface CustomerValidator {

  List<String> validate(Customer customer);
}
