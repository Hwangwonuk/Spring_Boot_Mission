/*
 * Created by Wonuk Hwang on 2022/03/19
 * As part of Bigin
 *
 * Copyright (C) Bigin (https://bigin.io/main) - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by infra Team <wonuk_hwang@bigin.io>, 2022/03/19
 */
package dev.wonuk.community.controller;

import dev.wonuk.community.entity.UserEntity;
import dev.wonuk.community.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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
@Controller
@RequestMapping("user")
public class MissionUserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private final UserRepository userRepository;

  public MissionUserController(@Autowired UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping("login")
  public String login() { return "login-form"; }

  @GetMapping("signup")
  public String signUp() { return "signup-form"; }

  @PostMapping("signup")
  public String signUpPost(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("password_check") String passwordCheck,
      @RequestParam("is_shop_owner") String isShopOwner
  ) {
    if (!password.equals(password)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    UserEntity newUser = new UserEntity();
    newUser.setUsername(username);
    newUser.setPassword(password);
    userRepository.save(newUser);

    return "redirect:/home";
  }
}
