package com.dev.cinema.service;

import com.dev.cinema.models.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    void add(MovieSession session);

    MovieSession getById(Long id);

}
