package com.dev.cinema.models.dto.moviesession;

import lombok.Getter;

@Getter
public class MovieSessionRequestCreateDto {
    private Long movieId;
    private Long cinemaHallId;
    private String showTime;
}
