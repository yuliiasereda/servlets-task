package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.EMAIL_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.USER_LOGIN_URL;
import static com.sereda.utils.EndpointConstants.USER_LOGOUT_URL;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(USER_LOGOUT_URL)
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doPost(
      HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(false);
    if (session != null) {
      Object userEmail = session.getAttribute(EMAIL_ATTRIBUTE);
      session.invalidate();
//      log.info("User [{}] was logged out!", userEmail);
    }
    resp.sendRedirect(req.getContextPath() + USER_LOGIN_URL);
  }
}
