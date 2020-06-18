package com.dev.cinema.service;

import com.dev.cinema.models.Role;

public interface RoleService {

    void add(Role role);

    Role getRoleByName(String roleName);
}
