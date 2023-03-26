package com.carlease.car.service;

import com.carlease.car.service.model.Car;
import com.carlease.car.service.repo.CarRepository;
import com.carlease.car.service.validation.CarValidator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  @Autowired
  CarRepository repo;

  @Autowired
  CarValidator validator;

  @Override
  public Optional<Car> findById(long carId) {
    return repo.findById(carId);
  }

  @Override
  public Car create(Car input) {
    if (input == null) {
      throw new IllegalArgumentException("new car cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("new car cannot have an id");
    }
    Car valid = validateOrThrow(input);
    return repo.save(valid);
  }

  @Override
  public Optional<Car> update(Car input) {
    if (input == null) {
      throw new IllegalArgumentException("car cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("car cannot have an id");
    }
    Car valid = validateOrThrow(input);
    if (repo.existsById(input.getId())) {
      return Optional.of(repo.save(valid));
    }
    return Optional.empty();
  }

  @Override
  public void delete(long carId) {
    repo.deleteById(carId);
  }

  @Override
  public Iterable<Car> getAll() {
    return repo.findAll();
  }

  private Car validateOrThrow(Car car) {
    List<String> errors = validator.validate(car);
    if (errors.isEmpty()) {
      return car;
    }
    throw new InvalidCarException(errors);
  }
}
