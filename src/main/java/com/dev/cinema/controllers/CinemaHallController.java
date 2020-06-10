package com.dev.cinema.controllers;

import com.dev.cinema.models.CinemaHall;
import com.dev.cinema.models.dto.cinemahall.CinemaHallRequestCreateDto;
import com.dev.cinema.models.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema_halls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CinemaHallRequestCreateDto req) {
        cinemaHallService.add(cinemaHallDtoToCinemaHall(req));
    }

    @GetMapping("/get_all")
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(this::cinemaHallToResponseDto)
                .collect(Collectors.toList());
    }

    private CinemaHall cinemaHallDtoToCinemaHall(CinemaHallRequestCreateDto req) {
        var capacity = req.getCapacity();
        var description = req.getDescription();
        return new CinemaHall(capacity, description);
    }

    private CinemaHallResponseDto cinemaHallToResponseDto(CinemaHall cinemaHall) {
        var id = cinemaHall.getId();
        var capacity = cinemaHall.getCapacity();
        var description = cinemaHall.getDescription();
        return new CinemaHallResponseDto(id, capacity, description);
    }
}
