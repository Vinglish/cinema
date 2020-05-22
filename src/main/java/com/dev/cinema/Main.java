package com.dev.cinema;

import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.cinema");
    
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHall redHall = new CinemaHall();
        redHall.setCapacity(150);
        redHall.setDescription("red hall");
        CinemaHallService cinemaHallService =
                (CinemaHallService) INJECTOR.getInstance(CinemaHallService.class);
        cinemaHallService.add(redHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession sessionOne = new MovieSession();
        sessionOne.setCinemaHall(redHall);
        sessionOne.setMovie(movie);
        sessionOne.setShowTime(LocalDateTime.of(LocalDate.of(2020, 5, 19),
                LocalTime.of(23, 30)));
        MovieSessionService movieSessionService =
                (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
        movieSessionService.add(sessionOne);
        List<MovieSession> sessions = movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.of(2020, 5, 19));
        sessions.forEach(System.out::println);
    }
}
