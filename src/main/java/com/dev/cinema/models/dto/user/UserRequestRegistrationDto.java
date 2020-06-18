package com.dev.cinema.models.dto.user;

import com.dev.cinema.annotations.EmailConstraint;
import com.dev.cinema.annotations.PasswordsValueMatch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
@PasswordsValueMatch
public class UserRequestRegistrationDto {

    @EmailConstraint
    private String email;

    @NotNull(message = "Password can't be null!")
    @Size(min = 8, message = "Number of symbols of password must be greater or equal 8!")
    private String password;

    @NotNull(message = "Repeat password can't be null!")
    private String repeatPassword;
}
