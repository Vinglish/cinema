package com.dev.cinema.models.dto.movie;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MovieRequestCreateDto {
    @NotNull(message = "Title can't be null!")
    private String title;

    @NotNull(message = "Description can't be null!")
    @Size(min = 8, max = 200, message = "Amount of symbols must be between 8 and 200")
    private String description;
}
