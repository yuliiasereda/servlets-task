package com.sereda.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doPost(
      HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(false);
    if (session != null) {
      session.invalidate();
      log.info("LOGOUT!");
    }
    resp.sendRedirect(req.getContextPath() + "/user/login");
  }
}
