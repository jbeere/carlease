package com.carlease.car.service.repo;

import org.springframework.data.repository.CrudRepository;
import com.carlease.car.service.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {



}
