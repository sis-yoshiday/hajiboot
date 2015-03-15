package com.example.repository;

import com.example.domain.Customer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  @Query("select x from Customer x order by x.firstName, x.lastName")
  Page<Customer> findAllOrderByName(Pageable pageable);
}
