package com.dev.cinema.models.mappers;

import com.dev.cinema.models.MovieSession;
import com.dev.cinema.models.dto.moviesession.MovieSessionRequestCreateDto;
import com.dev.cinema.models.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;

    public MovieSessionMapper(MovieService movieService, CinemaHallService cinemaHallService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    public MovieSession dtoToEntity(
            MovieSessionRequestCreateDto req) {
        var movie = movieService.getById(req.getMovieId());
        var cinemaHall = cinemaHallService.getById(req.getCinemaHallId());
        var showTime = LocalDateTime.parse(req.getShowTime());
        return new MovieSession(movie, cinemaHall, showTime);
    }

    public MovieSessionResponseDto entityToDto(
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
