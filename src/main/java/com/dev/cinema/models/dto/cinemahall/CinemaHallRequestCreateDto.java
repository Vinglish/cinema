package com.dev.cinema.models.dto.cinemahall;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CinemaHallRequestCreateDto {
    @NotNull(message = "Capacity can't be empty!")
    private int capacity;
    @NotNull(message = "Can't be null!")
    @Size(min = 6, max = 150, message = "Number of symbols must be between 6 and 150!")
    private String description;
}
