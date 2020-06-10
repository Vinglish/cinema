package com.dev.cinema.controllers;

import com.dev.cinema.models.Order;
import com.dev.cinema.models.ShoppingCart;
import com.dev.cinema.models.Ticket;
import com.dev.cinema.models.User;
import com.dev.cinema.models.dto.order.OrderRequestCreateDto;
import com.dev.cinema.models.dto.order.OrderResponseDto;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(UserService userService, ShoppingCartService shoppingCartService,
                           OrderService orderService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
    }

    @PostMapping("/complete")
    public void complete(@RequestBody OrderRequestCreateDto req) {
        User user = userService.getById(req.getId());
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        orderService.completeOrder(shoppingCart.getTickets(), user);
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistoryOfUser(
            @RequestParam(name = "userId") Long id) {
        User user = userService.getById(id);
        return orderService.getOrderHistory(user)
                .stream()
                .map(this::orderToOrderResponseDto)
                .collect(Collectors.toList());
    }

    private OrderResponseDto orderToOrderResponseDto(Order order) {
        var id = order.getId();
        var userId = order.getUser().getId();
        var orderTime = order.getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        List<Long> ticketsId = order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        return new OrderResponseDto(id, userId, orderTime, ticketsId);
    }
}
