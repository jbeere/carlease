package com.carlease.lease.service;

import com.carlease.car.service.dto.CarDTO;
import com.carlease.lease.service.calc.LeaseRateCalculator;
import com.carlease.lease.service.client.CarServiceClient;
import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseServiceImpl implements LeaseService {

  @Autowired
  private CarServiceClient carServiceClient;

  @Override
  public LeaseCalculationResponse calculate(String make, String model,
      LeaseCalculationRequest request) {
    Optional<CarDTO> car = carServiceClient.getCar(make, model);
    BigDecimal nettPrice = car.map(CarDTO::getNettPrice)
        .orElseThrow(() -> new IllegalArgumentException(
            String.format("Make %s Model %s Not Found", make, model)));
    BigDecimal answer = LeaseRateCalculator.builder()
        .duration(request.getDuration())
        .interestRate(request.getInterestRate())
        .mileage(request.getMileage())
        .nettPrice(nettPrice)
        .build().calculate();
    return LeaseCalculationResponse.builder()
        .duration(request.getDuration())
        .interestRate(request.getInterestRate())
        .mileage(request.getMileage())
        .nettPrice(nettPrice)
        .leaseRate(answer)
        .build();
  }
}
