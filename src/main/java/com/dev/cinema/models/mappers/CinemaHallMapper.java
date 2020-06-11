package com.dev.cinema.models.mappers;

import com.dev.cinema.models.CinemaHall;
import com.dev.cinema.models.dto.cinemahall.CinemaHallRequestCreateDto;
import com.dev.cinema.models.dto.cinemahall.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHall dtoToEntity(CinemaHallRequestCreateDto req) {
        var capacity = req.getCapacity();
        var description = req.getDescription();
        return new CinemaHall(capacity, description);
    }

    public CinemaHallResponseDto entityToDto(CinemaHall cinemaHall) {
        var id = cinemaHall.getId();
        var capacity = cinemaHall.getCapacity();
        var description = cinemaHall.getDescription();
        return new CinemaHallResponseDto(id, capacity, description);
    }
}
