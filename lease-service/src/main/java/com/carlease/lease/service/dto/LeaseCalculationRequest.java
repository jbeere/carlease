package com.carlease.lease.service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LeaseCalculationRequest {

  private BigDecimal mileage;

  private int duration;

  private BigDecimal interestRate;

}
