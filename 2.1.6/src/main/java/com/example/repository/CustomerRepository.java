package com.example.repository;

import com.example.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Repository;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Repository public class CustomerRepository {

  private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>();

  public List<Customer> findAll() {
    return new ArrayList<>(customerMap.values());
  }

  public Customer findOne(Integer id) {
    return customerMap.get(id);
  }

  public Customer save(Customer customer) {
    return customerMap.put(customer.getId(), customer);
  }

  public void delete(Integer id) {
    customerMap.remove(id);
  }
}
