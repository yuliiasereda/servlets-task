package com.sereda.listener;

import com.sereda.model.User;
import com.sereda.service.UserService;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContext servletContext = servletContextEvent.getServletContext();
    UserService userService = new UserService(new ArrayList<User>());
    servletContext.setAttribute("user-service", userService);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
