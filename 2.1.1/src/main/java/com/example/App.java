package com.example;

import com.example.app.Calculator;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication @Import(AppConfig.class) public class App {

  public static void main(String[] args) {

    try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
         Scanner scanner = new Scanner(System.in)
    ) {

      System.out.print("Enter 2 numbers like 'a b' : ");
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      Calculator calculator = context.getBean(Calculator.class);
      int result = calculator.calc(a, b);
      System.out.println("result = " + result);
    }
  }
}
