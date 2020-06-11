package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.TicketDao;
import com.dev.cinema.models.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Ticket ticket) {
        em.persist(ticket);
    }
}
