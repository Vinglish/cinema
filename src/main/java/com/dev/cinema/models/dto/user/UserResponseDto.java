package com.dev.cinema.models.dto.user;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long id;
    private String email;

    public UserResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
