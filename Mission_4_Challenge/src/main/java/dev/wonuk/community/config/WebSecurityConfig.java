/*
 * Created by Wonuk Hwang on 2022/03/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2022/03/19
 */
package dev.wonuk.community.config;

import dev.wonuk.community.filter.CustomFilter;
import dev.wonuk.community.filter.CustomSuccessHandler;
import dev.wonuk.community.infra.NaverOAuth2Service;
import dev.wonuk.community.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final NaverOAuth2Service oAuth2UserService;
  private final CustomSuccessHandler customSuccessHandler;

  public WebSecurityConfig(
      @Autowired CustomUserDetailsService customUserDetailsService,
      @Autowired NaverOAuth2Service oAuth2UserService,
      @Autowired CustomSuccessHandler customSuccessHandler
  ){
    this.userDetailsService = customUserDetailsService;
    this.oAuth2UserService = oAuth2UserService;
    this.customSuccessHandler = customSuccessHandler;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
          .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
          .authorizeRequests()
          .antMatchers(
              "/home/**",
              "/user/signup/**",
              "/",
              "/css/**",
              "/images/**",
              "/js/**"
          )
          .permitAll()
          .anyRequest()
          .authenticated()
        .and()
          .formLogin()
          .loginPage("/user/login")
          .defaultSuccessUrl("/home")
          .successHandler(customSuccessHandler)
        .and()
          .logout()
          .logoutUrl("/user/logout")
          .logoutSuccessUrl("/home")
          .deleteCookies("JSEESIONID")
          .invalidateHttpSession(true)
          .permitAll()
        .and()
          .oauth2Login()
          .userInfoEndpoint()
          .userService(this.oAuth2UserService)
          .and()
          .defaultSuccessUrl("/home")
        .and()
          .oauth2Client()
    ;
  }
}
