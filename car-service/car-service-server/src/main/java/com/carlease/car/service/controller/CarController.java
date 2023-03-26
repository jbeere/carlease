package com.carlease.car.service.controller;

import com.carlease.car.service.CarService;
import com.carlease.car.service.dto.CarDTO;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/cars")
@ComponentScan("com.carlease.car")
public class CarController {

  @Autowired
  CarService service;

  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public Iterable<CarDTO> findAll(@RequestParam(name = "make", required = false) final String make,
      @RequestParam(name = "model", required = false) final String model) {
    return service.findByMakeAndModel(make, model);
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CarDTO> create(@RequestBody final CarDTO input,
      HttpServletRequest request) {
    CarDTO created = service.create(input);
    Long id = created.getId();
    UriComponentsBuilder uri = ServletUriComponentsBuilder.fromRequest(request);
    URI location = uri.path("/{id}").buildAndExpand(String.valueOf(id)).toUri();
    return ResponseEntity.created(location).body(created);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CarDTO> findById(@PathVariable final long id) {
    return ResponseEntity.of(service.findById(id));
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CarDTO> update(@PathVariable final long id,
      @RequestBody final CarDTO input) {
    if (id != input.getId()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.of(service.update(input));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> delete(@PathVariable long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }
}
