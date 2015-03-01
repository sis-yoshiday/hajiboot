package com.example;

import com.example.app.AddCalculator;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import com.example.app.ScannerArgumentResolver;
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

  @Bean ArgumentResolver argumentResolver() {
    return new ScannerArgumentResolver();
  }

  @Bean Frontend frontend() {
    return new Frontend();
  }
}
