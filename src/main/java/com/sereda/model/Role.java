package com.sereda.model;

import lombok.Getter;

@Getter
public enum Role {
  USER("/user/home"), ADMIN("/management/users");
  private final String homeUrl;

  Role(String homeUrl) {
    this.homeUrl = homeUrl;
  }
}
