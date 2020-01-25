package com.sereda.servlet;

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
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/management/users")
public class ManagementUsersServlet extends HttpServlet {

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
    List<User> users = userService.getUsers();
    req.setAttribute("users", users);
    req.getRequestDispatcher("/WEB-INF/management.jsp").forward(req, resp);
    log.info("Get all registered users");
  }
}
