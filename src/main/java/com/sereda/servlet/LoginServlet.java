package com.sereda.servlet;

import com.sereda.helper.JsonHelper;
import com.sereda.model.UpdateUserDto;
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
@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {

  UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute("user-service");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    log.info("Get login page");
  }

  @Override
  protected void doPut(
      HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    UpdateUserDto user = JsonHelper.getUserObjectFromJson(JsonHelper.inputStreamToString(req.getInputStream()));
    String email = user.getEmail();
    String password = user.getPassword();
    if (userService.loggedInUser(email, password)) {
      log.info("User is logged");
    }
    req.getSession().setAttribute("userEmail", email);
  }
}
