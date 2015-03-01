package com.example.app;

import org.springframework.stereotype.Component;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Component
public class AddCalculator implements Calculator {
  @Override public int calc(int a, int b) {
    return a + b;
  }
}
