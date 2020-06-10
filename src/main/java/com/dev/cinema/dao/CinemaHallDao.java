package com.dev.cinema.dao;

import com.dev.cinema.model.CinemaHall;
import java.util.List;

public interface CinemaHallDao {
    void add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();

}
