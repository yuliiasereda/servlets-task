package com.sereda.model;

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
  private Role role;

  @Builder
  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.status = LoginStatus.NON_LOGGED_IN;
    this.role = Role.USER;
  }

  @Builder
  public User(String name, String email, String password, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.status = LoginStatus.NON_LOGGED_IN;
    this.role = role;
  }
}
