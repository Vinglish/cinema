package com.dev.cinema.dao;

import com.dev.cinema.models.ShoppingCart;
import com.dev.cinema.models.User;

public interface ShoppingCartDao {
    void add(ShoppingCart shoppingCart);
        
    ShoppingCart getByUser(User user);
        
    void update(ShoppingCart shoppingCart);
}
