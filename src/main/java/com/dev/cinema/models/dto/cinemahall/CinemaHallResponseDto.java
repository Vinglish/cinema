package com.dev.cinema.models.dto.cinemahall;

import lombok.Getter;

@Getter
public class CinemaHallResponseDto {
    private Long id;
    private int capacity;
    private String description;

    public CinemaHallResponseDto(Long id, int capacity, String description) {
        this.id = id;
        this.capacity = capacity;
        this.description = description;
    }
}
