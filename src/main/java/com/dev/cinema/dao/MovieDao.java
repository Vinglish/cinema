package com.dev.cinema.dao;

import com.dev.cinema.model.Movie;
import java.util.List;

public interface MovieDao {
    void add(Movie movie);
    
    List<Movie> getAll();
}
