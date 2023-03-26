package com.carlease.customer.service.model;

import javax.persistence.*;

@Entity
public class Customer {

  private Long id;

  private String name;

  private String street;

  private String houseNumber;

  private String zipCode;

  private String place;

  private String emailAddress;

  private String phoneNumber;

  public Customer() {

  }

  public Customer(long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  @Column
  public void setId(Long id) {
    this.id = id;
  }

  @Column
  public String getName() {
    return name;
  }

  @Column
  public void setName(String name) {
    this.name = name;
  }

  @Column
  public String getStreet() {
    return street;
  }

  @Column
  public void setStreet(String street) {
    this.street = street;
  }

  @Column(name = "house_number")
  public String getHouseNumber() {
    return houseNumber;
  }

  @Column
  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  @Column
  public String getZipCode() {
    return zipCode;
  }

  @Column(name = "zip_code")
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Column
  public String getPlace() {
    return place;
  }

  @Column
  public void setPlace(String place) {
    this.place = place;
  }

  @Column(name = "email_address")
  public String getEmailAddress() {
    return emailAddress;
  }

  @Column
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  @Column
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Column(name = "phone_number")
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
