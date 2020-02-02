package com.sereda.dao;

import com.sereda.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Storage {

  public List<User> users;

  public void addUser(User user) {
    users.add(user);
  }

  public void removeUser(User user) {
    users.remove(user);
  }

  public List<User> fetchAllUsers() {
    return new ArrayList<>(users);
  }

  public Optional<User> getUserByEmail(String email) {
    return users.stream()
        .filter(user -> email.equals(user.getEmail()))
        .findFirst();
  }

  public boolean isEmailUsed(String email) {
    return users.stream()
        .map(User::getEmail)
        .anyMatch(email::equals);
  }
}