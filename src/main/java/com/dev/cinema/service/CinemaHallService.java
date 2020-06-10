package com.dev.cinema.service;

import com.dev.cinema.models.CinemaHall;
import java.util.List;

public interface CinemaHallService {
    void add(CinemaHall cinemaHall);
    
    List<CinemaHall> getAll();

    CinemaHall getById(Long id);
}
