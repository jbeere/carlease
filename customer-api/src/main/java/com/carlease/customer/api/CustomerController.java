package com.carlease.customer.api;

import com.carlease.customer.entity.Customer;
import com.carlease.customer.service.CustomerService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customers")
@ComponentScan("com.carlease.customer")
public class CustomerController {

  @Autowired
  CustomerService service;

  @PostMapping("/")
  public ResponseEntity<Customer> create(@RequestBody final Customer input,
      HttpServletRequest request) {
    Customer created = service.create(input);
    Long id = created.getId();
    UriComponentsBuilder uri = ServletUriComponentsBuilder.fromRequest(request);
    URI location = uri.path("/{id}").buildAndExpand(String.valueOf(id)).toUri();
    return ResponseEntity.created(location).body(created);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> findById(@PathVariable final long id) {
    return ResponseEntity.of(service.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> update(@PathVariable final long id,
      @RequestBody final Customer input) {
    if (id != input.getId()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.of(service.update(input));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }
}
