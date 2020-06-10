package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.ShoppingCartDao;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(ShoppingCart shoppingCart) {
        em.persist(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        TypedQuery<ShoppingCart> query = em
                .createQuery("FROM ShoppingCart sc "
                                + "LEFT JOIN FETCH sc.tickets "
                                + "WHERE sc.id = :id",
                        ShoppingCart.class);
        query.setParameter("id", user.getId());
        return query.getSingleResult();
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        em.merge(shoppingCart);
    }
}
