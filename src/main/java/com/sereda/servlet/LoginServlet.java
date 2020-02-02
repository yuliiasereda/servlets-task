package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.EMAIL_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.LOGIN_JSP;
import static com.sereda.utils.EndpointConstants.USER_LOGIN_URL;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

import com.sereda.dto.AuthenticateUserDto;
import com.sereda.dto.UpdateUserDto;
import com.sereda.exception.AuthenticationException;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(USER_LOGIN_URL)
public class LoginServlet extends HttpServlet {

  UserService userService;

  @Override
  public void init() throws ServletException {
    super.init();
    ServletContext servletContext = getServletContext();
    userService = (UserService) servletContext.getAttribute(USER_SERVICE_ATTRIBUTE);
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
    log.info("Get login page");

  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    UpdateUserDto user = JsonHelper.getUserObjectFromInputStream(req.getInputStream());
    String email = user.getEmail();
    String password = user.getPassword();
    try {
      User authenticate = userService.authenticate(email, password);
      req.getSession().setAttribute(EMAIL_ATTRIBUTE, email);
      log.info("User is logged in");
      JsonHelper.sendResponse(resp, new AuthenticateUserDto(authenticate.getRole().getHomeUrl()));
    } catch (AuthenticationException e) {
      log.warn("User cannot be logged in");
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }
}
