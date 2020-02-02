package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.EMAIL_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.MANAGEMENT_JSP;
import static com.sereda.utils.EndpointConstants.MANAGEMENT_USER_URL;
import static com.sereda.utils.EndpointConstants.USERS_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

import com.sereda.dto.UpdateUserDto;
import com.sereda.helper.JsonHelper;
import com.sereda.model.User;
import com.sereda.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(MANAGEMENT_USER_URL)
public class ManagementUserServlet extends HttpServlet {

  UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute(USER_SERVICE_ATTRIBUTE);
  }

  @Override
  protected void doPost(
      HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    log.info("Getting all registered users");
    List<User> users = userService.fetchAllUsers();
    req.setAttribute(USERS_ATTRIBUTE, users);
    req.getRequestDispatcher(MANAGEMENT_JSP).forward(req, resp);
  }

  @Override
  protected void doPut(
      HttpServletRequest req, HttpServletResponse resp) throws IOException {
    UpdateUserDto userDto = JsonHelper.getUserObjectFromInputStream(req.getInputStream());
    String name = userDto.getName();
    String email = userDto.getEmail();
    String oldEmail = userDto.getOldEmail();
    String password = userDto.getPassword();
    userService.updateUser(new User(name, email, password), oldEmail);
  }

  @Override
  protected void doDelete(
      HttpServletRequest req, HttpServletResponse resp) throws IOException {
    UpdateUserDto userDto = JsonHelper.getUserObjectFromInputStream(req.getInputStream());
    User user = userService.getUserByEmail(userDto.getEmail());
    userService.deleteUser(user);
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String email = req.getParameter(EMAIL_ATTRIBUTE);
    userService.getUserByEmail(email);
  }
}

