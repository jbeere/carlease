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
public class LeaseCalculationResponse {

  private BigDecimal mileage;

  private int duration;

  private BigDecimal interestRate;

  private BigDecimal nettPrice;

  private BigDecimal leaseRate;

}
