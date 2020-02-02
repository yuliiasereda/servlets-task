package com.sereda.listener;

import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

import com.sereda.dao.Storage;
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
    UserService userService = new UserService(new Storage(new ArrayList<>()));
    servletContext.setAttribute(USER_SERVICE_ATTRIBUTE, userService);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    // Not to be implemented
  }
}
