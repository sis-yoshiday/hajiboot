package com.example;

import com.example.app.AddCalculator;
import com.example.app.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Configuration
public class AppConfig {

  @Bean Calculator calculator() {
    return new AddCalculator();
  }
}
