package com.dev.cinema.dao;

import com.dev.cinema.models.Order;
import com.dev.cinema.models.User;
import java.util.List;

public interface OrderDao {
    void add(Order order);

    List<Order> getOrderHistory(User user);
}
