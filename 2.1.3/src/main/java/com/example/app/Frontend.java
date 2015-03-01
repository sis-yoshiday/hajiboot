package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
public class Frontend {

  @Autowired ArgumentResolver argumentResolver;

  @Autowired Calculator calculator;

  public void run() {

    System.out.print("Enter 2 numbers like 'a b' : ");
    Argument argument = argumentResolver.resolve(System.in);

    int result = calculator.calc(argument.getA(), argument.getB());
    System.out.println("result = " + result);
  }
}
