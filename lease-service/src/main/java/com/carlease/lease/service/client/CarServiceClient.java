package com.carlease.lease.service.client;

import com.carlease.car.service.dto.CarDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CarServiceClient {

  @Autowired
  private WebClient.Builder webClient;

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
    return Optional.of(cars.get(0));
  }

}
