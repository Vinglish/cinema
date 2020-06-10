package com.dev.cinema.dao;

import com.dev.cinema.models.User;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    Optional<User> findByEmail(String email);

    User getById(Long id);

}
