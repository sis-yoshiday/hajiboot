package com.example.app;

import java.io.InputStream;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
public interface ArgumentResolver {

  Argument resolve(InputStream inputStream);
}
