package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by yuki_yoshida on 15/03/19.
 */
@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

  @Autowired CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET) Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
    return customerService.findAll(pageable);
  }

  @RequestMapping(method = RequestMethod.GET, value = "{id}")
  Customer getCustomer(@PathVariable Integer id) {
    return customerService.findOne(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder) {
    Customer created = customerService.create(customer);
    HttpHeaders headers = new HttpHeaders();
    URI location = uriComponentsBuilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
    headers.setLocation(location);
    return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "{id}")
  Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
    customer.setId(id);
    return customerService.update(customer);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteCustomer(@PathVariable Integer id) {
    customerService.delete(id);
  }



}
