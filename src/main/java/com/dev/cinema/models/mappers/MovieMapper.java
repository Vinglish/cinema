package com.dev.cinema.models.mappers;

import com.dev.cinema.models.Movie;
import com.dev.cinema.models.dto.movie.MovieRequestCreateDto;
import com.dev.cinema.models.dto.movie.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie dtoToEntity(MovieRequestCreateDto requestDto) {
        var title = requestDto.getTitle();
        var description = requestDto.getDescription();
        return new Movie(title, description);
    }

    public MovieResponseDto entityToDto(Movie movie) {
        var movieId = movie.getId();
        var title = movie.getTitle();
        var description = movie.getDescription();
        return new MovieResponseDto(movieId, title, description);
    }
}
