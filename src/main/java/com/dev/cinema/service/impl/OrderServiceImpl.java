package com.dev.cinema.service.impl;

import com.dev.cinema.dao.OrderDao;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.User;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void completeOrder(List<Ticket> tickets, User user) {
        List<Ticket> ticketList = new ArrayList<>(tickets);
        var order = new Order(LocalDateTime.now(), ticketList, user);
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        orderDao.add(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}
