package com.example.app;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
public class AddCalculator implements Calculator {
  @Override public int calc(int a, int b) {
    return a + b;
  }
}
