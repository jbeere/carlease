package com.carlease.customer.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.carlease.customer.entity.Customer;
import com.carlease.customer.repo.CustomerRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CustomerRepository repo;

  @Test
  public void testCreateAndGetCustomer() throws Exception {
    long random = (long) Math.floor(Math.random() * 1000);
    Customer customer = new Customer(random);
    when(repo.save(any(Customer.class))).thenReturn(customer);
    when(repo.findById(random)).thenReturn(Optional.of(customer));
    this.mockMvc.perform(
            post("/api/customers/").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"x\"}"))
        .andDo((result) -> {
          String location = result.getResponse().getHeader("Location");
          Assertions.assertNotNull(location);
          this.mockMvc.perform(get(location)).andExpect(status().isOk());
        });
  }
}
