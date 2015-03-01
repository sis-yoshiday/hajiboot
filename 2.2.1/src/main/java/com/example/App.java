package com.example;

import com.example.domain.Customer;
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

  @Autowired NamedParameterJdbcTemplate jdbcTemplate;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override public void run(String... args) throws Exception {

    String sql = "select id, first_name, last_name from customers where id = :id";
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", 1);
    Customer result = jdbcTemplate.queryForObject(sql, param,
        (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"),
            rs.getString("last_name")));

    System.out.println("result = " + result);
  }
}
