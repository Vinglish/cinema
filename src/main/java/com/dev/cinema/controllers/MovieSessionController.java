package com.dev.cinema.controllers;

import com.dev.cinema.models.MovieSession;
import com.dev.cinema.models.dto.moviesession.MovieSessionRequestCreateDto;
import com.dev.cinema.models.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie_session")
public class MovieSessionController {

    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieService movieService,
                                  CinemaHallService cinemaHallService,
                                  MovieSessionService movieSessionService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping("/add")
    public void addMovieSession(@RequestBody MovieSessionRequestCreateDto req) {
        movieSessionService.add(movieSessionRequestDtoToMovieSession(req));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableSessions(Long movieId, String date) {
        return movieSessionService.findAvailableSessions(movieId, LocalDate.parse(date))
                .stream()
                .map(this::movieSessionToMovieSessionResponseDto)
                .collect(Collectors.toList());
    }

    private MovieSession movieSessionRequestDtoToMovieSession(
            MovieSessionRequestCreateDto req) {
        var movie = movieService.getById(req.getMovieId());
        var cinemaHall = cinemaHallService.getById(req.getCinemaHallId());
        var showTime = LocalDateTime.parse(req.getShowTime());
        return new MovieSession(movie, cinemaHall, showTime);
    }

    private MovieSessionResponseDto movieSessionToMovieSessionResponseDto(
            MovieSession movieSession) {
        var movieSessionId = movieSession.getId();
        var movieId = movieSession.getMovie().getId();
        var cinemaHallId = movieSession.getCinemaHall().getId();
        var showTime = movieSession.getShowTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        return new MovieSessionResponseDto(
                movieSessionId, movieId, cinemaHallId, showTime
        );
    }
}
