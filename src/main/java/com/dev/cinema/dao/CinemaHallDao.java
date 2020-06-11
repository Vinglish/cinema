package com.dev.cinema.dao;

import com.dev.cinema.models.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    void add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

    CinemaHall getById(Long id);
}
