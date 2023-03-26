package com.carlease.lease.service;

import com.carlease.lease.service.dto.LeaseCalculationRequest;
import com.carlease.lease.service.dto.LeaseCalculationResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class LeaseServiceImpl implements LeaseService {

  @Override
  public LeaseCalculationResponse calculate(String make, String model,
      LeaseCalculationRequest request) {
    BigDecimal nettPrice = new BigDecimal(200000); // todo fetch from cars
    BigDecimal twelve = new BigDecimal(12);
    BigDecimal hundred = new BigDecimal(100);
    BigDecimal mileage = request.getMileage();
    BigDecimal duration = BigDecimal.valueOf(request.getDuration());
    BigDecimal interestRate = request.getInterestRate();
    //((( mileage / 12 )*duration )/Nett price) + ((( Interest rate / 100 ) * Nett price) / 12)
    BigDecimal answer =
        (((mileage.divide(twelve, RoundingMode.HALF_UP))
            .multiply(duration)).divide(nettPrice, RoundingMode.HALF_UP))
            .add(((interestRate.divide(hundred, RoundingMode.HALF_UP))
                .multiply(nettPrice)).divide(twelve, RoundingMode.HALF_UP));
    return LeaseCalculationResponse.builder().duration(request.getDuration())
        .mileage(request.getMileage()).nettPrice(nettPrice)
        .interestRate(request.getInterestRate()).leaseRate(answer).build();
  }
}
