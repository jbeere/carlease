package com.carlease.car.service;

import java.util.List;

public class InvalidCarException extends RuntimeException {
  private final List<String> errors;

  public InvalidCarException(List<String> errors) {
    super(String.join("; ", errors));
    this.errors = errors;
  }

  public List<String> getErrors() {
    return errors;
  }
}
