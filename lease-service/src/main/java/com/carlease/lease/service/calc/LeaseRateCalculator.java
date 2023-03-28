package com.carlease.lease.service.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Builder;

@Builder
public class LeaseRateCalculator {

  private static BigDecimal twelve = BigDecimal.valueOf(12);

  private BigDecimal mileage;

  private int duration;

  private BigDecimal interestRate;

  private BigDecimal nettPrice;

  @Builder.Default
  private RoundingMode roundingMode = RoundingMode.HALF_EVEN;

  @Builder.Default
  private int scale = 8;

  // ((( mileage / 12 )*duration )/Nett price) + ((( Interest rate / 100 ) * Nett price) / 12)
  public BigDecimal calculate() {
    BigDecimal a = mileage.setScale(scale, roundingMode).divide(twelve,roundingMode);
    BigDecimal b = a.multiply(BigDecimal.valueOf(duration));
    BigDecimal c = b.divide(nettPrice, roundingMode);
    // +
    BigDecimal d = interestRate.multiply(nettPrice);
    BigDecimal e = d.divide(twelve, roundingMode);
    // =
    return c.add(e);
  }

  //239.82142857
}
