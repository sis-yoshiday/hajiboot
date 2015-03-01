package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication @Import(AppConfig.class) public class App {

  public static void main(String[] args) {

    try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)
    ) {

      System.out.print("Enter 2 numbers like 'a b' : ");
      ArgumentResolver resolver = context.getBean(ArgumentResolver.class);
      Argument argument = resolver.resolve(System.in);

      Calculator calculator = context.getBean(Calculator.class);
      int result = calculator.calc(argument.getA(), argument.getB());
      System.out.println("result = " + result);
    }
  }
}
