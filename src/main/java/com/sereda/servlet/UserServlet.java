package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.EMAIL_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_HOME_URL;
import static com.sereda.utils.EndpointConstants.USER_JSP;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

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
@WebServlet(USER_HOME_URL)
public class UserServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute(USER_SERVICE_ATTRIBUTE);
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userEmail = (String) req.getSession().getAttribute(EMAIL_ATTRIBUTE);
    User userByEmail = userService.getUserByEmail(userEmail);
    req.setAttribute(USER_ATTRIBUTE, userByEmail);
    req.getRequestDispatcher(USER_JSP).forward(req, resp);
    log.info("Get user");
  }
}
