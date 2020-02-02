package com.sereda.service;

import com.sereda.dao.Storage;
import com.sereda.exception.AuthenticationException;
import com.sereda.model.LoginStatus;
import com.sereda.model.User;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class UserService {

  private Storage storage;

  public void createUser(User user) {
    validate(user);
    if (storage.isEmailUsed(user.getEmail())) {
      log.info("This user already exists");
      throw new RuntimeException();
    }
    storage.addUser(user);
  }

  public void deleteUser(User user) {
    validate(user);
    if (!storage.isEmailUsed(user.getEmail())) {
      log.info("This user doesn't exist");
      throw new RuntimeException();
    } else {
      storage.removeUser(user);
    }
  }

  public void updateUser(User updatedUser, String oldEmail) {
    validate(updatedUser);
    if (!storage.isEmailUsed(oldEmail)) {
      log.info("This user doesn't exists");
      throw new RuntimeException();
    }
    if (storage.isEmailUsed(updatedUser.getEmail())) {
      log.info("This email already exists");
      throw new RuntimeException();
    } else {
      User user = getUserByEmail(oldEmail);
      user.setName(updatedUser.getName());
      user.setPassword(updatedUser.getPassword());
      user.setEmail(updatedUser.getEmail());
    }
  }

  public List<User> fetchAllUsers() {
    return storage.fetchAllUsers();
  }

  public User getUserByEmail(String email){
    return storage.getUserByEmail(email).orElseThrow(RuntimeException::new);
  }

  public User authenticate(String email, String password) {
    User user = getUserByEmail(email);
    if (user.getPassword().equals(password)) {
      user.setStatus(LoginStatus.LOGGED_IN);
    } else {
      log.warn("This user has another password");
      throw new AuthenticationException();
    }
    return user;
  }

  private void validate(User user) {
    if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
      log.info("The name, email or password is empty");
      throw new RuntimeException();
    }
  }
}
