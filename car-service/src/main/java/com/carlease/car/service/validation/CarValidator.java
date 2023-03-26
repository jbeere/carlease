package com.carlease.car.service.validation;

import com.carlease.car.service.model.Car;
import java.util.List;

public interface CarValidator {

  List<String> validate(Car car);
}
