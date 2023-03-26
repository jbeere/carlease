package com.carlease.lease.service;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.carlease.car.service.dto.CarDTO;
import com.carlease.lease.service.client.CarServiceClient;
import com.carlease.lease.service.controller.LeaseController;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LeaseController.class)
public class LeaseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CarServiceClient carServiceClient;

  @Test
  public void testCreateAndGetLease() throws Exception {
    when(carServiceClient.getCar("BMW", "XM")).thenReturn(Optional.of(CarDTO.builder().nettPrice(
        BigDecimal.TEN).build()));
    this.mockMvc.perform(
            post("/api/lease/car/BMW/XM/rate").contentType(MediaType.APPLICATION_JSON)
                .content("{\"mileage\":30, \"duration\":1, \"interestRate\": 14.5}"))
        .andDo(print());
  }
}
