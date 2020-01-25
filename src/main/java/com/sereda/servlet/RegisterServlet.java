package com.sereda.servlet;

import com.sereda.helper.JsonHelper;
import com.sereda.model.User;
import com.sereda.service.UserService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/user/signup")
public class RegisterServlet extends HttpServlet {

  UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute("user-service");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
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
    try {
      userService.addUser(name, email, password);
      resp.sendRedirect(req.getContextPath() + "/user/login");
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
