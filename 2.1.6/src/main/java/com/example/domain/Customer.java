package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Data @AllArgsConstructor public class Customer {

  private Integer id;
  private String firstName;
  private String lastName;
}
