package com.dev.cinema.controllers;

import com.dev.cinema.models.dto.cinemahall.CinemaHallRequestCreateDto;
import com.dev.cinema.models.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.models.mappers.CinemaHallMapper;
import com.dev.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemahalls")
public class CinemaHallController {
    private final CinemaHallService cinemaHallService;
    private final CinemaHallMapper cinemaHallMapper;

    public CinemaHallController(CinemaHallService cinemaHallService,
                                CinemaHallMapper cinemaHallMapper) {
        this.cinemaHallService = cinemaHallService;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    @PostMapping
    public void add(@RequestBody @Valid CinemaHallRequestCreateDto req) {
        cinemaHallService.add(cinemaHallMapper.dtoToEntity(req));
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll()
                .stream()
                .map(cinemaHallMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
