package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.models.MovieSession;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        TypedQuery<MovieSession> query = em.createQuery(
                "FROM MovieSession ms "
                        + "JOIN FETCH ms.movie JOIN FETCH ms.cinemaHall "
                        + "WHERE ms.movie.id = :movie_id AND ms.showTime > :date",
                MovieSession.class);
        query.setParameter("movie_id", movieId);
        query.setParameter("date",date.atStartOfDay());
        return query.getResultList();
    }

    @Override
    public void add(MovieSession movieSession) {
        em.persist(movieSession);
    }

    @Override
    public MovieSession getById(Long id) {
        TypedQuery<MovieSession> query = em.createQuery(
                "FROM MovieSession WHERE id = :id", MovieSession.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
