package com.carlease.lease.service.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaseCalculatorTest {

  /*
  Example calculation:
  - Mileage: 45000 km/yr
  - Duration: 60 months
  - Interest rate: 4.5%
  - Nett Price: € 63000
  - Leaserate: € 239,76 per month
   */
  @Test
  public void test() {
    BigDecimal mileage = BigDecimal.valueOf(45000);
    int duration = 60;
    BigDecimal interestRate = BigDecimal.valueOf(0.045);
    BigDecimal nettPrice = BigDecimal.valueOf(63000);
    BigDecimal answer = LeaseRateCalculator.builder()
        .mileage(mileage)
        .duration(duration)
        .interestRate(interestRate)
        .nettPrice(nettPrice)
        .roundingMode(RoundingMode.HALF_UP).build()
        .calculate();
    BigDecimal expected = new BigDecimal("239.76");
    BigDecimal tolerance = BigDecimal.valueOf(0.07);
    BigDecimal diff = expected.subtract(answer).abs();
    assertEquals(tolerance.subtract(diff).min(BigDecimal.ZERO), BigDecimal.ZERO,
        "leaseRate is within tolerance");

  }
}
