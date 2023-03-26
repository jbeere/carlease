package com.carlease.car.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.carlease.car.service.controller.CarController;
import com.carlease.car.service.model.Car;
import com.carlease.car.service.repo.CarRepository;
import java.util.Optional;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CarController.class)
public class CarControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CarRepository repo;

  @Test
  public void testCreateAndGetCar() throws Exception {
    long random = (long) Math.floor(Math.random() * 1000);
    Car car = Car.builder().id(random).build();
    when(repo.save(any(Car.class))).thenReturn(car);
    when(repo.findById(random)).thenReturn(Optional.of(car));
    this.mockMvc.perform(
            post("/api/cars/").contentType(MediaType.APPLICATION_JSON)
                .content("{\"make\":\"x\", \"model\":\"y\"}"))
        .andDo((result) -> {
          String location = result.getResponse().getHeader("Location");
          Assertions.assertNotNull(location);
          this.mockMvc.perform(get(location)).andExpect(status().isOk());
        });
  }

  @Test
  public void testFindByMakeAndModel() throws Exception {
    long random = (long) Math.floor(Math.random() * 1000);
    Car car = Car.builder().id(random).make("BMW").model("XM").build();
    when(repo.findByMakeAndModel("BMW", "XM")).thenReturn(Lists.list(car));
    this.mockMvc.perform(
            get("/api/cars").param("make", "BMW").param("model", "XM")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print());
  }
}
