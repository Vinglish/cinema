package com.dev.cinema.dao;

import com.dev.cinema.models.Role;

public interface RoleDao {

    void add(Role role);

    Role getRoleByName(String roleName);
}
