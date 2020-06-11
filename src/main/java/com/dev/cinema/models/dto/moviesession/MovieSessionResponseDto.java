package com.dev.cinema.models.dto.moviesession;

import lombok.Getter;

@Getter
public class MovieSessionResponseDto {
    private Long id;
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;

    public MovieSessionResponseDto(Long id, Long movieId,
                                   Long cinemaHallId, String showTime) {
        this.id = id;
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.showTime = showTime;
    }
}
