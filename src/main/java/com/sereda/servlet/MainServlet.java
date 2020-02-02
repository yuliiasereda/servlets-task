package com.sereda.servlet;

import static com.sereda.utils.EndpointConstants.LOGIN_JSP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("")
public class MainServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("Get login page");
    req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
  }
}
