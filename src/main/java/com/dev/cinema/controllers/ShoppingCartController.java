package com.dev.cinema.controllers;

import com.dev.cinema.models.MovieSession;
import com.dev.cinema.models.dto.user.UserResponseDto;
import com.dev.cinema.models.mappers.ShoppingCartMapper;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService, ShoppingCartMapper shoppingCartMapper) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/add-movie-session")
    public void add(@RequestParam Long movieSessionId,
                    Authentication auth) {
        var user = userService.findByEmail(auth.getName());
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public UserResponseDto get(Authentication auth) {
        var user = userService.findByEmail(auth.getName());
        return shoppingCartMapper.entityToDto(user);
    }
}
