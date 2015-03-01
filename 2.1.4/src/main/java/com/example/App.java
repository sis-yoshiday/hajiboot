package com.example;

import com.example.app.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication public class App {

  public static void main(String[] args) {

    try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)
    ) {

      Frontend frontend = context.getBean(Frontend.class);
      frontend.run();
    }
  }
}
