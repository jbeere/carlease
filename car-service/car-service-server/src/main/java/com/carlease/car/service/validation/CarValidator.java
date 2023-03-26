package com.carlease.car.service.validation;

import com.carlease.car.service.dto.CarDTO;
import java.util.List;

public interface CarValidator {

  List<String> validate(CarDTO car);
}
