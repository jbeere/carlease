package com.carlease.car.service.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a Car in the carlease rest api
 *
 * // todo this should have been in /car-service/car-service-client and imported as a dependency
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO {

  private Long id;

  private String make;

  private String model;

  private String version;

  private int doorCount;

  private BigDecimal co2Emissions;

  private BigDecimal grossPrice;

  private BigDecimal nettPrice;
}
