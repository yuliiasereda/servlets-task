package com.sereda.servlet;

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
@WebServlet("/user/home")
public class UserServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute("user-service");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) {
    String userEmail = (String) req.getSession().getAttribute("userEmail");
    User userByEmail = userService.getUserByEmail(userEmail);
    req.setAttribute("user", userByEmail);
    log.info("Get user");
  }
}
