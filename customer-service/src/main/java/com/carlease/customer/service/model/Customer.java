package com.carlease.customer.service.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private String street;

  @Column(name = "house_number")
  private String houseNumber;

  @Column(name = "zip_code")
  private String zipCode;

  @Column
  private String place;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "phone_number")
  private String phoneNumber;
}
