package com.sereda.filter;

import static com.sereda.utils.EndpointConstants.EMAIL_ATTRIBUTE;
import static com.sereda.utils.EndpointConstants.MANAGEMENT_USERS_URL;
import static com.sereda.utils.EndpointConstants.MANAGEMENT_USER_URL;
import static com.sereda.utils.EndpointConstants.USER_HOME_URL;
import static com.sereda.utils.EndpointConstants.USER_LOGIN_URL;
import static com.sereda.utils.EndpointConstants.USER_SERVICE_ATTRIBUTE;

import com.sereda.model.User;
import com.sereda.service.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {USER_HOME_URL, MANAGEMENT_USERS_URL, MANAGEMENT_USER_URL})
public class SessionCheckFilter implements Filter {

  private String contextPath;
  private UserService userService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    ServletContext servletContext = filterConfig.getServletContext();
    userService = (UserService) servletContext.getAttribute(USER_SERVICE_ATTRIBUTE);
    contextPath = filterConfig.getServletContext().getContextPath();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;


    String email = (String) req.getSession().getAttribute(EMAIL_ATTRIBUTE);
    User user = userService.getUserByEmail(email);
    if (user == null) {
      res.sendRedirect(contextPath + USER_LOGIN_URL);
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  @Override
  public void destroy() {

  }
}
