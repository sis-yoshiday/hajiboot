package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * Created by yuki_yoshida on 15/03/22.
 */
@Data public class CustomerForm {

  @NotNull @Size(min = 1, max = 127) private String firstName;
  @NotNull @Size(min = 1, max = 127) private String lastName;
}
