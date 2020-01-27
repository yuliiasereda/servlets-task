package com.sereda.filter;

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

@WebFilter(urlPatterns = {"/user/home", "/management/users", "/management/user"})
public class SessionCheckFilter implements Filter {

  private String contextPath;
  private UserService userService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    ServletContext servletContext = filterConfig.getServletContext();
    userService = (UserService) servletContext.getAttribute("user-service");
    contextPath = filterConfig.getServletContext().getContextPath();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;


    String email = (String) req.getSession().getAttribute("userEmail");
    User user = userService.getUserByEmail(email);
    if (user == null) {
      res.sendRedirect(contextPath + "/user/login");
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  @Override
  public void destroy() {

  }
}
