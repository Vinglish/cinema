package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.OrderDao;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Order order) {
        em.persist(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        TypedQuery<Order> query = em
                .createQuery("SELECT DISTINCT o "
                        + "FROM Order o LEFT JOIN FETCH o.tickets "
                        + "WHERE o.user.id = :id", Order.class);
        query.setParameter("id", user.getId());
        return query.getResultList();

    }
}
