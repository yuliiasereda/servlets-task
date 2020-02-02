package com.sereda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

  private String name;
  private String email;
  private String password;
  private LoginStatus status = LoginStatus.NON_LOGGED_IN;
  private Role role;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = Role.USER;
  }

  public User(String name, String email, String password, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
