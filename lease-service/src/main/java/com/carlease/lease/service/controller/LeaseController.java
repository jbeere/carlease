package com.carlease.lease.service.controller;

import com.carlease.lease.service.LeaseService;
import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;
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
  public LeaseCalculationResponse calculateLeaseRate(
      @PathVariable final String make, @PathVariable final String model,
      @RequestBody LeaseCalculationRequest request) {
    return service.calculate(make, model, request);
  }
}
