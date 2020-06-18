package com.dev.cinema.dao;

import com.dev.cinema.models.User;

public interface UserDao {
    void add(User user);

    User findByEmail(String email);

    User getById(Long id);

}
