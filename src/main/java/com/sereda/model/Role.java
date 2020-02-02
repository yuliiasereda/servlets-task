package com.sereda.model;

import static com.sereda.utils.EndpointConstants.MANAGEMENT_USERS_URL;
import static com.sereda.utils.EndpointConstants.USER_HOME_URL;

import lombok.Getter;

@Getter
public enum Role {
  USER(USER_HOME_URL), ADMIN(MANAGEMENT_USERS_URL);
  private final String homeUrl;

  Role(String homeUrl) {
    this.homeUrl = homeUrl;
  }
}
