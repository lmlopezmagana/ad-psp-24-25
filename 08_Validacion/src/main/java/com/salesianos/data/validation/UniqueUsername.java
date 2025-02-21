package com.salesianos.data.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface UniqueUsername {

    String message() default "El nombre de usuario no puede estar repetido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
