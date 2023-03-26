package com.carlease.car.service.repo;

import com.carlease.car.service.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface CarRepository extends CrudRepository<Car, Long> {

  @Query("SELECT c FROM Car c WHERE (:make is null or c.make = :make) and (:model is null or c.model = :model)")
  Iterable<Car> findByMakeAndModel(@Param("make") String make, @Param("model") String model);


}
