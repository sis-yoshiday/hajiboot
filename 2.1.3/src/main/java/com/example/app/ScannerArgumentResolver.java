package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
public class ScannerArgumentResolver implements ArgumentResolver {
  @Override public Argument resolve(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream);
    return new Argument(scanner.nextInt(), scanner.nextInt());
  }
}
