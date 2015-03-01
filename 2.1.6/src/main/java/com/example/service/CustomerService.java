package com.example.service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Service
public class CustomerService {

  @Autowired CustomerRepository repository;

  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  public List<Customer> findAll() {
    return repository.findAll();
  }
}
