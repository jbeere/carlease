package com.carlease.car.service;

import com.carlease.car.service.dto.CarDTO;
import java.util.Optional;

public interface CarService {
  Optional<CarDTO> findById(long customerId);

  Iterable<CarDTO> findByMakeAndModel(String make, String model);

  CarDTO create(CarDTO input);

  Optional<CarDTO> update(CarDTO input);

  void delete(long customerId);

  Iterable<CarDTO> getAll();


}
