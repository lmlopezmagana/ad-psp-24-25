package com.salesianostriana.dam.restquerylang.util;

public record SearchCriteria(
        String key,
        String operation,
        Object value
) {
}
