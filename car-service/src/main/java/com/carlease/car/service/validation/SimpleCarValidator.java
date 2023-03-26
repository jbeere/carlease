package com.carlease.car.service.validation;

import com.carlease.car.service.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class SimpleCarValidator implements CarValidator {

  @Override
  public List<String> validate(Car car) {
    List<String> errors = new ArrayList<>();
    if (Objects.equals(car.getMake(), "")) {
      errors.add("car make cannot be null or empty");
    }
    if (Objects.equals(car.getModel(), "")) {
      errors.add("car model cannot be null or empty");
    }
    return errors;
  }
}
