package com.carlease.lease.service.client;

import com.carlease.car.service.dto.CarDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implements a client for the restful car-service api.
 *
 * Connects to the car-service and executes rest methods to implement service-2-service
 * communication between rest apis.
 *
 * // todo this should have been in /car-service/car-service-client and imported as a dependency
 */
@Component
public class CarServiceClient {

  @Autowired
  private WebClient.Builder webClient;

  /**
   * Gets a car from the car-service.
   *
   * Connects to the car-service rest api via service discovery and load balancing.
   *
   * @param make The make of the vehicle
   * @param model The model of the vehicle
   * @return An optional value for the car if found, if not found - Optional.empty()
   */
  public Optional<CarDTO> getCar(String make, String model) {
    ResponseEntity<List<CarDTO>> response = webClient.baseUrl("http://car-service/car/api")
        .build()
        .get()
        .uri(b -> b.path("/cars/").queryParam("make", make).queryParam("model", model).build())
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .toEntityList(CarDTO.class).block();
    if (response == null) {
      throw new IllegalStateException("Web Client Response from car-service was null");
    }
    List<CarDTO> cars = response.getBody();
    if (cars == null) {
      throw new IllegalArgumentException("Web Client Response body was null");
    }
    if (cars.isEmpty()) {
      return Optional.empty();
    }
    // todo come up with a better identification strategy for cars
    return Optional.of(cars.get(0));
  }

}
