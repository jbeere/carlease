package com.carlease.car.service;

import com.carlease.car.service.model.Car;
import java.util.Optional;

public interface CarService {
  Optional<Car> findById(long customerId);

  Car create(Car input);

  Optional<Car> update(Car input);

  void delete(long customerId);

  Iterable<Car> getAll();


}
