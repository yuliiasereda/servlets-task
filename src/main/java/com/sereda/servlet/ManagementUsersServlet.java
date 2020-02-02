package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.MANAGEMENT_JSP;
import static com.sereda.utils.EndpointConstants.MANAGEMENT_USERS_URL;
import static com.sereda.utils.EndpointConstants.USERS_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

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
@WebServlet(MANAGEMENT_USERS_URL)
public class ManagementUsersServlet extends HttpServlet {

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
    List<User> users = userService.fetchAllUsers();
    req.setAttribute(USERS_ATTRIBUTE, users);
    req.getRequestDispatcher(MANAGEMENT_JSP).forward(req, resp);
    log.info("Get all registered users");
  }
}
