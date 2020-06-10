package com.dev.cinema.models.dto.movie;

import lombok.Getter;

@Getter
public class MovieResponseDto {
    private Long id;
    private String title;
    private String description;

    public MovieResponseDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
