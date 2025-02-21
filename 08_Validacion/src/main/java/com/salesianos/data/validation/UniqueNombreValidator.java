package com.salesianos.data.validation;

import com.salesianos.data.repos.ProductoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueNombreValidator implements ConstraintValidator<UniqueNombre, String> {

    @Autowired
    private ProductoRepository repo;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repo.existsByNombre(s);
    }
}
