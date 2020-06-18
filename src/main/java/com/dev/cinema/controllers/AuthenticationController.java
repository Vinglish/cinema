package com.dev.cinema.controllers;

import com.dev.cinema.models.dto.user.UserRequestRegistrationDto;
import com.dev.cinema.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registration")
    public void register(@RequestBody @Valid UserRequestRegistrationDto req) {
        authenticationService.register(req.getEmail(),
                req.getPassword());
    }
}
