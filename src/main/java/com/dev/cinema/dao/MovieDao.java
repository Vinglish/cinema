package com.dev.cinema.dao;

import com.dev.cinema.models.Movie;
import java.util.List;

public interface MovieDao {
    void add(Movie movie);
    
    List<Movie> getAll();

    Movie getById(Long id);
}
