package com.example;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication public class App implements CommandLineRunner {

  @Autowired CustomerService service;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override public void run(String... args) throws Exception {

    service.save(new Customer(1, "Nobita", "Nobi"));
    service.save(new Customer(2, "Takeshi", "Goda"));
    service.save(new Customer(3, "Suneo", "Honekawa"));

    service.findAll().forEach(System.out::println);
  }
}
