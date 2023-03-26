package com.carlease.customer.service.validation;

import com.carlease.customer.service.model.Customer;
import java.util.List;

public interface CustomerValidator {

  List<String> validate(Customer customer);
}
