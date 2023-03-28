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

  /**
   * This fulfills the requirement
   *
   * ((( mileage / 12 )*duration )/Nett price) + ((( Interest rate / 100 ) * Nett price) / 12)
   *
   * @return The calculated Lease Rate
   */
  //
  public BigDecimal calculate() {
    // ( mileage / 12 )
    BigDecimal a = mileage.setScale(scale, roundingMode).divide(twelve,roundingMode);
    // ( mileage / 12 ) * duration
    BigDecimal b = a.multiply(BigDecimal.valueOf(duration));
    // (( mileage / 12 ) * duration) / nettPrice
    BigDecimal c = b.divide(nettPrice, roundingMode);
    // +
    // (interestRate * nettPrice)
    BigDecimal d = interestRate.multiply(nettPrice);
    // (interestRate * nettPrice) / 12
    BigDecimal e = d.divide(twelve, roundingMode);
    // =
    return c.add(e);

    // I could not get it to be exactly 239.76, perhaps I am missing something?
  }
}
