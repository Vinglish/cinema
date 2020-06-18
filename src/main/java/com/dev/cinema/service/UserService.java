package com.dev.cinema.service;

import com.dev.cinema.models.User;

public interface UserService {
    void add(User user);

    User findByEmail(String email);

    User getById(Long id);
}
