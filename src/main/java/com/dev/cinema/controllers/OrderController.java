package com.dev.cinema.controllers;

import com.dev.cinema.models.ShoppingCart;
import com.dev.cinema.models.User;
import com.dev.cinema.models.dto.order.OrderResponseDto;
import com.dev.cinema.models.mappers.OrderMapper;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final OrderMapper orderMapper;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService, OrderMapper orderMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/complete")
    public void complete(@RequestParam @Valid Long userId) {
        User user = userService.getById(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        orderService.completeOrder(shoppingCart.getTickets(), user);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistoryOfUser(Authentication auth) {
        var user = userService.findByEmail(auth.getName());
        return orderService.getOrderHistory(user)
                .stream()
                .map(orderMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
