package com.dev.cinema.controllers;

import com.dev.cinema.models.Movie;
import com.dev.cinema.models.dto.movie.MovieRequestCreateDto;
import com.dev.cinema.models.dto.movie.MovieResponseDto;
import com.dev.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody MovieRequestCreateDto requestDto) {
        movieService.add(movieRequestDtoToMovie(requestDto));
    }

    @GetMapping("/get_all")
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(this::movieToMovieResponseDto)
                .collect(Collectors.toList());
    }

    private Movie movieRequestDtoToMovie(MovieRequestCreateDto requestDto) {
        var title = requestDto.getTitle();
        var description = requestDto.getDescription();
        return new Movie(title, description);
    }

    private MovieResponseDto movieToMovieResponseDto(Movie movie) {
        var movieId = movie.getId();
        var title = movie.getTitle();
        var description = movie.getDescription();
        return new MovieResponseDto(movieId, title, description);
    }
}
