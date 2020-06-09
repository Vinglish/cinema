package com.dev.cinema.service.impl;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.service.CinemaHallService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CinemaHallServiceImpl implements CinemaHallService {

    private final CinemaHallDao cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public void add(CinemaHall cinemaHall) {
        cinemaHallDao.add(cinemaHall);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
