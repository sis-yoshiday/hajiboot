package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yuki_yoshida on 15/02/28.
 */
@SpringBootApplication public class App implements CommandLineRunner {

  @Autowired ArgumentResolver argumentResolver;

  @Autowired Calculator calculator;

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override public void run(String... args) throws Exception {

    System.out.print("Enter 2 numbers like 'a b' : ");
    Argument argument = argumentResolver.resolve(System.in);

    int result = calculator.calc(argument.getA(), argument.getB());
    System.out.println("result = " + result);
  }
}
