package com.carlease.car.service;

import com.carlease.car.service.dto.CarDTO;
import com.carlease.car.service.model.Car;
import com.carlease.car.service.repo.CarRepository;
import com.carlease.car.service.validation.CarValidator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  @Autowired
  CarRepository repo;

  @Autowired
  CarValidator validator;

  @Override
  public Optional<CarDTO> findById(long customerId) {
    return repo.findById(customerId).map(CarServiceImpl::toDTO);
  }

  @Override
  public Iterable<CarDTO> findByMakeAndModel(String make, String model) {
    return toDTOIterable(repo.findByMakeAndModel(make, model));
  }

  @Override
  public CarDTO create(CarDTO input) {
    if (input == null) {
      throw new IllegalArgumentException("new car cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("new car cannot have an id");
    }
    Car valid = validateOrThrow(input);
    return toDTO(repo.save(valid));
  }

  @Override
  public Optional<CarDTO> update(CarDTO input) {
    if (input == null) {
      throw new IllegalArgumentException("car cannot be null");
    }
    if (input.getId() != null) {
      throw new IllegalArgumentException("car cannot have an id");
    }
    Car valid = validateOrThrow(input);
    if (repo.existsById(input.getId())) {
      return Optional.of(repo.save(valid)).map(CarServiceImpl::toDTO);
    }
    return Optional.empty();
  }

  @Override
  public void delete(long carId) {
    repo.deleteById(carId);
  }

  @Override
  public Iterable<CarDTO> getAll() {
    return toDTOIterable(repo.findAll());
  }

  private Car validateOrThrow(CarDTO car) {
    List<String> errors = validator.validate(car);
    if (errors.isEmpty()) {
      return fromDTO(car);
    }
    throw new InvalidCarException(errors);
  }

  private static Iterable<CarDTO> toDTOIterable(final Iterable<Car> car) {
    return () -> StreamSupport.stream(
            Spliterators.spliteratorUnknownSize(car.iterator(), Spliterator.ORDERED),
            false)
        .map(CarServiceImpl::toDTO).iterator();
  }

  private static CarDTO toDTO(Car car) {
    return CarDTO.builder()
        .id(car.getId())
        .make(car.getMake())
        .model(car.getModel())
        .version(car.getVersion())
        .co2Emissions(car.getCo2Emissions())
        .doorCount(car.getDoorCount())
        .grossPrice(car.getGrossPrice())
        .nettPrice(car.getNettPrice())
        .build();
  }

  private static Car fromDTO(CarDTO car) {
    return Car.builder()
        .id(car.getId())
        .make(car.getMake())
        .model(car.getModel())
        .version(car.getVersion())
        .co2Emissions(car.getCo2Emissions())
        .doorCount(car.getDoorCount())
        .grossPrice(car.getGrossPrice())
        .nettPrice(car.getNettPrice())
        .build();
  }
}
