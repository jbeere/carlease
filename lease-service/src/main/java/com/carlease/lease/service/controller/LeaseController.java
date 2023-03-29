package com.carlease.lease.service.controller;

import com.carlease.lease.service.LeaseService;
import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lease")
@ComponentScan("com.carlease.lease")
public class LeaseController {

  @Autowired
  private LeaseService service;

  @PostMapping("/car/{make}/{model}/rate")
  @Operation(summary = "Calculates the lease rate for a vehicle by make and model")
  public LeaseCalculationResponse calculateLeaseRate(
      @PathVariable @NotBlank @Parameter(description = "The make of the vehicle - e.g. BMW") final String make,
      @NotBlank @PathVariable @Parameter(description = "The model of the vehicle - e.g. XM") final String model,
      @RequestBody LeaseCalculationRequest request) {
    return service.calculate(make, model, request);
  }
}
