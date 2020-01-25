package com.sereda.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class User {

  private String name;
  private String email;
  private String password;
  private LoginStatus status;
  private List<Role> roles;

  @Builder
  public User(String name, String email, String password){
    this.name = name;
    this.email = email;
    this.password = password;
    this.status = LoginStatus.NON_LOGGED_IN;
    this.roles = Arrays.asList(Role.USER);
  }

  @Builder
  public User(String name, String email, String password, ArrayList<Role> roles){
    this.name = name;
    this.email = email;
    this.password = password;
    this.status = LoginStatus.NON_LOGGED_IN;
    this.roles = roles;
  }
}
