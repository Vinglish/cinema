package com.dev.cinema.controllers;

import com.dev.cinema.models.MovieSession;
import com.dev.cinema.models.User;
import com.dev.cinema.models.dto.user.UserResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PostMapping("/add_movie_session")
    public void add(@RequestParam Long movieSessionId,
                    @RequestParam Long userId) {
        User user = userService.getById(userId);
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/get_by_user")
    public UserResponseDto get(@RequestParam(name = "userId") Long id) {
        var user = userService.getById(id);
        return userToUserResponseDto(user);
    }

    private UserResponseDto userToUserResponseDto(User user) {
        var id = user.getId();
        var email = user.getEmail();
        return new UserResponseDto(id, email);
    }
}
