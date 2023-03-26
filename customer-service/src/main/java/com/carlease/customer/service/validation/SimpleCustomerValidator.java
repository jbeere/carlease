package com.carlease.customer.service.validation;

import com.carlease.customer.service.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class SimpleCustomerValidator implements CustomerValidator {

  @Override
  public List<String> validate(Customer customer) {
    List<String> errors = new ArrayList<>();
    if (Objects.equals(customer.getName(), "")) {
      errors.add("customer name cannot be null or empty");
    }
    return errors;
  }
}
