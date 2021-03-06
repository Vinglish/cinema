package com.dev.cinema.dao;

import com.dev.cinema.models.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void add(MovieSession session);

    MovieSession getById(Long id);
}
