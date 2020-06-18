package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.RoleDao;
import com.dev.cinema.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Role role) {
        em.persist(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        TypedQuery<Role> query = em.createQuery(
                "FROM Role r WHERE roleName = :roleName", Role.class);
        query.setParameter("roleName", Role.RoleName.valueOf(roleName));
        return query.getSingleResult();

    }
}
