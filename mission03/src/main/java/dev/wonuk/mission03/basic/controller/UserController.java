package dev.wonuk.mission03.basic.controller;

import dev.wonuk.mission03.basic.dto.UserDTO;
import dev.wonuk.mission03.basic.entity.UserEntity;
import dev.wonuk.mission03.basic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserEntity createUser(@RequestBody UserDTO dto) {
        logger.info(dto.toString());
        return this.userService.createUser(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<UserEntity> getUser(@PathVariable Long id) {
        logger.info("getUser target id: " + id);
        return this.userService.getUser(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody UserDTO dto) {
        logger.info("updateUser target id: " + id);
        logger.info("update content :" + dto);
        this.userService.updateUser(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("deleteUser target id: " + id);
        this.userService.deleteUser(id);
    }
}
