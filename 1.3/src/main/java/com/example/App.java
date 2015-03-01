package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@RestController @SpringBootApplication public class App {

  @RequestMapping("/") String home() {
    //return "Hello world!";
    return "Hello Spring Boot!";
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
