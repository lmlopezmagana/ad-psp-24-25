package com.salesianos.data.validation;

import com.salesianos.data.repos.ProductoRepository;
import com.salesianos.data.repos.UsuarioRepositroy;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UsuarioRepositroy repo;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repo.existsByUsername(s);
    }
}
