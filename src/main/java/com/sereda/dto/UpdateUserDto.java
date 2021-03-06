package com.sereda.dto;

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
