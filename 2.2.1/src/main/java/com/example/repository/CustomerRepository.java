package com.example.repository;

import com.example.domain.Customer;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Repository @Transactional public class CustomerRepository {

  @Autowired NamedParameterJdbcTemplate jdbcTemplate;

  SimpleJdbcInsert insert;

  @PostConstruct public void init() {
    insert = new SimpleJdbcInsert((JdbcTemplate) jdbcTemplate.getJdbcOperations()).withTableName(
        "customers").usingGeneratedKeyColumns("id");
  }

  private static final RowMapper<Customer> customerRowMapper =
      (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("first_name"),
          rs.getString("last_name"));

  public List<Customer> findAll() {
    return jdbcTemplate.query("select id, first_name, last_name from customers order by id",
        customerRowMapper);
  }

  public <T> Customer findOne(Integer id) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    return jdbcTemplate.queryForObject(
        "select id, first_name, last_name from customers where id = :id", param, customerRowMapper);
  }

  public Customer save(Customer customer) {
    SqlParameterSource param = new BeanPropertySqlParameterSource(customer);
    if (customer.getId() == null) {
      jdbcTemplate.update(
          "insert into customers (first_name, last_name) values (:firstName, :lastName)", param);
      customer.setId(insert.executeAndReturnKey(param).intValue());
    } else {
      jdbcTemplate.update("update customers set first_name=:firstName, last_name=:lastName", param);
    }
    return customer;
  }

  public void delete(Integer id) {
    SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    jdbcTemplate.update("delete from customers where id = :id", param);
  }
}
