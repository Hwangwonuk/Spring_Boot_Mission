/*
 * Created by Wonuk Hwang on 2022/03/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2022/03/19
 */
package dev.wonuk.community.filter;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * create on 2022/03/19. create by IntelliJ IDEA.
 *
 * <p> </p>
 * <p> {@link } and {@link } </p> *
 *
 * @author wonukHwang
 * @version 1.0
 * @see
 * @since (ex : 5 + 5)
 */
@Component
public class CustomFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    if(httpServletRequest.getQueryString().contains("likelion_login_cookie")) {
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      httpServletResponse.addCookie(new Cookie("likelion_login_cookie", "test_value"));
    }

    SecurityContextHolder.getContext().setAuthentication(new Authentication() {
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
      }

      @Override
      public Object getCredentials() {
        return null;
      }

      @Override
      public Object getDetails() {
        return null;
      }

      @Override
      public Object getPrincipal() {
        return (Principal) () -> "dummy";
      }

      @Override
      public boolean isAuthenticated() {
        return true;
      }

      @Override
      public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

      }

      @Override
      public String getName() {
        return "dummy";
      }
    });
    chain.doFilter(request, response);
  }

}

