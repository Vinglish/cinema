package com.dev.cinema.controllers;

import com.dev.cinema.models.dto.moviesession.MovieSessionRequestCreateDto;
import com.dev.cinema.models.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.models.mappers.MovieSessionMapper;
import com.dev.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviesessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieSessionMapper movieSessionMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  MovieSessionMapper movieSessionMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionMapper = movieSessionMapper;
    }

    @PostMapping
    public void addMovieSession(@RequestBody @Valid MovieSessionRequestCreateDto req) {
        movieSessionService.add(movieSessionMapper.dtoToEntity(req));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableSessions(Long movieId, String date) {
        return movieSessionService.findAvailableSessions(movieId, LocalDate.parse(date))
                .stream()
                .map(movieSessionMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
