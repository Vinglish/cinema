package com.dev.cinema.service;

import com.dev.cinema.model.Movie;
import java.util.List;

public interface MovieService {
    void add(Movie movie);
    
    List<Movie> getAll();

}
