package com.dev.cinema.controllers;

import com.dev.cinema.models.User;
import com.dev.cinema.models.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get_by_email/{email}")
    public UserResponseDto get(
            @PathVariable String email) {
        var user = userService.findByEmail(email).orElseThrow();
        return userToUserResponseDto(user);
    }

    private UserResponseDto userToUserResponseDto(User user) {
        var id = user.getId();
        var email = user.getEmail();
        return new UserResponseDto(id, email);
    }
}
