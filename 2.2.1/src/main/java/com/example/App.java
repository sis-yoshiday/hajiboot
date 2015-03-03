package com.example;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication public class App implements CommandLineRunner {

  @Autowired CustomerRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override public void run(String... args) throws Exception {

    Customer created = repository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
    System.out.println(created + " is created!");

    repository.findAll().forEach(System.out::println);
  }
}
