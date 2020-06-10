package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.models.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements MovieDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Movie movie) {
        em.persist(movie);
    }

    @Override
    public List<Movie> getAll() {
        TypedQuery<Movie> query = em.createQuery("FROM Movie", Movie.class);
        return query.getResultList();
    }

    @Override
    public Movie getById(Long id) {
        TypedQuery<Movie> query = em.createQuery(
                "FROM Movie WHERE id = :id", Movie.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
