package com.carlease.customer.service;

import java.util.List;

public class InvalidCustomerException extends RuntimeException {
  private final List<String> errors;

  public InvalidCustomerException(List<String> errors) {
    super(String.join("; ", errors));
    this.errors = errors;
  }

  public List<String> getErrors() {
    return errors;
  }
}
