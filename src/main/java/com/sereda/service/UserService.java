package com.sereda.service;

import com.sereda.model.LoginStatus;
import java.util.List;
import com.sereda.model.User;
import java.util.Optional;
import lombok.extern.log4j.Log4j;

@Log4j
public class UserService {

  List<User> users;

  public UserService(List<User> users) {
    this.users = users;
  }

  public User addUser(String name, String email, String password) {
    if (name.equals("") || email.equals("") || password.equals("")) {
      log.info("The name, email or password is empty");
      throw new RuntimeException();
    }
    if (hasUser(email)) {
      log.info("This user already exists");
      throw new RuntimeException();
    } else {
      User user = new User(name, email, password);
      users.add(user);
      return user;
    }
  }

  public User updateUser(String name, String email, String password, String oldEmail) {
    if (email.equals("")) {
      log.info("The email is empty");
      throw new RuntimeException();
    }
    if (!hasUser(oldEmail)) {
      log.info("This user doesn't exist");
      throw new RuntimeException();
    } else {
      User user = getUserByEmail(oldEmail);
      user.setName(name == null ? user.getName() : name);
      user.setPassword(password == null ? user.getPassword() : password);
      user.setEmail(email == null ? oldEmail : email);
      return user;
    }
  }

  public User deleteUser(String email) {
    if (email.equals("")) {
      log.info("The email is empty");
      throw new RuntimeException();
    }
    if (!hasUser(email)) {
      log.info("This user doesn't exist");
      throw new RuntimeException();
    } else {
      User user = getUserByEmail(email);
      users.remove(user);
      return user;
    }
  }

  public boolean loggedInUser(String email, String password) {
    User user = getUserByEmail(email);
    if (user.getPassword().equals(password)) {
      user.setStatus(LoginStatus.LOGGED_IN);
      return true;
    } else {
      log.info("This user has another password");
      throw new RuntimeException();
    }
  }

  public List<User> getUsers() {
    return users;
  }

  public User getUserByEmail(String email) {
    Optional<User> first = users.stream().filter(user -> email.equals(user.getEmail()))
        .findFirst();
    return first.orElseThrow(RuntimeException::new);
  }

  private boolean hasUser(String email) {
    return users.stream()
        .anyMatch(user -> email.equals(user.getEmail()));
  }
}
