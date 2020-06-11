package com.dev.cinema.service.impl;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.models.Movie;
import com.dev.cinema.service.MovieService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void add(Movie movie) {
        movieDao.add(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie getById(Long id) {
        return movieDao.getById(id);
    }
}
