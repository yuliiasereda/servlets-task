package com.sereda.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UpdateUserDto {

  private String name;
  private String email;
  private String oldEmail;
  private String password;
}
