package com.dev.cinema.models.mappers;

import com.dev.cinema.models.User;
import com.dev.cinema.models.dto.user.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public UserResponseDto entityToDto(User user) {
        var id = user.getId();
        var email = user.getEmail();
        return new UserResponseDto(id, email);
    }
}
