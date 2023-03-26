package com.carlease.car.service.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String make;

  @Column
  private String model;

  @Column
  private String version;

  @Column(name="door_count")
  private int doorCount;

  @Column(name="co2_emmissions")
  private BigDecimal co2Emissions;

  @Column(name="gross_price")
  private BigDecimal grossPrice;

  @Column(name="nett_proce")
  private BigDecimal nettPrice;
}
