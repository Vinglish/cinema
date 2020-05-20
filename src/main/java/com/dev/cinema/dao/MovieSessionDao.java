package com.dev.cinema.dao;

import java.util.List;
import java.time.LocalDate;
import com.dev.cinema.model.MovieSession;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);
}
