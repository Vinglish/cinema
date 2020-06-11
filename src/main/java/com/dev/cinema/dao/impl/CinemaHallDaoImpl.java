package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.models.CinemaHall;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(CinemaHall cinemaHall) {
        em.persist(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        TypedQuery<CinemaHall> query = em.createQuery("FROM CinemaHall", CinemaHall.class);
        return query.getResultList();
    }

    @Override
    public CinemaHall getById(Long id) {
        TypedQuery<CinemaHall> query = em.createQuery(
                "FROM CinemaHall WHERE id = :id", CinemaHall.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
