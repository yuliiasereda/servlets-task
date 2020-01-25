package com.sereda.model;

public enum LoginStatus {
  LOGGED_IN(true), NON_LOGGED_IN(false);

  private final boolean isLogged;

  LoginStatus(boolean isLogged) {
    this.isLogged = isLogged;
  }
}
