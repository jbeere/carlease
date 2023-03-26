package com.carlease.lease.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.carlease.lease.service.controller.LeaseController;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LeaseController.class)
public class LeaseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testCreateAndGetLease() throws Exception {
    this.mockMvc.perform(
            post("/api/lease/car/BMW/XM/rate").contentType(MediaType.APPLICATION_JSON)
                .content("{\"mileage\":30, \"duration\":1, \"interestRate\": 14.5}"))
        .andDo(print());
  }
}
