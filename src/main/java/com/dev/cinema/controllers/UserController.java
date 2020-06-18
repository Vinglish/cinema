package com.dev.cinema.controllers;

import com.dev.cinema.models.dto.user.UserResponseDto;
import com.dev.cinema.models.mappers.UserMapper;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam String email) {
        var user = userService.findByEmail(email);
        return userMapper.entityToDto(user);
    }
}
