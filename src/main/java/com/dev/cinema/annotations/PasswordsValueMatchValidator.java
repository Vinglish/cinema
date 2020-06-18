package com.dev.cinema.annotations;

import com.dev.cinema.models.dto.user.UserRequestRegistrationDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValueMatchValidator implements
        ConstraintValidator<PasswordsValueMatch, UserRequestRegistrationDto> {

    @Override
    public boolean isValid(UserRequestRegistrationDto req, ConstraintValidatorContext
            constraintValidatorContext) {
        String password = req.getPassword();
        String repeatPassword = req.getRepeatPassword();
        return password != null && password.equals(repeatPassword);
    }
}
