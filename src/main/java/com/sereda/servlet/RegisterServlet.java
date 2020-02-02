package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.SIGNUP_JSP;
import static com.sereda.utils.EndpointConstants.USER_LOGIN_URL;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_SIGNUP_URL;

import com.sereda.model.User;
import com.sereda.service.UserService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(USER_SIGNUP_URL)
public class RegisterServlet extends HttpServlet {

  UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute(USER_SERVICE_ATTRIBUTE);
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    req.getRequestDispatcher(SIGNUP_JSP).forward(req, resp);
    log.info("Get user");
  }

//  @Override
//  protected void doDelete(
//      HttpServletRequest req, HttpServletResponse resp) throws IOException {
//    String email = req.getParameter("email");
//    try {
//      User user = userService.deleteUser(email);
//      JsonHelper.getJsonOfObject(resp, user);
//      log.info("Delete user");
//    } catch (RuntimeException e) {
//      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
//    }
//  }

  @Override
  protected void doPost(
      HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String email = req.getParameter("email");
    String name = req.getParameter("name");
    String password = req.getParameter("pass");
    User user = new User(name, email, password);
    try {
      userService.createUser(user);
      resp.sendRedirect(req.getContextPath() + USER_LOGIN_URL);
      log.info("Register user");
    } catch (RuntimeException e) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

//  @Override
//  protected void doPut(
//      HttpServletRequest req, HttpServletResponse resp) throws IOException {
//    String email = req.getParameter("email");
//    String name = req.getParameter("name");
//    String password = req.getParameter("pass");
//    try {
//      User user = userService.updateUser(email, name, password, email);
//      JsonHelper.getJsonOfObject(resp, user);
//      log.info("Update user info");
//    } catch (RuntimeException e) {
//      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
//    }
//  }
}
