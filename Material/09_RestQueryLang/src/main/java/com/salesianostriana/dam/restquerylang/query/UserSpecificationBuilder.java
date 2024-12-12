package com.salesianostriana.dam.restquerylang.query;

import com.salesianostriana.dam.restquerylang.model.User;
import com.salesianostriana.dam.restquerylang.util.SearchCriteria;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserSpecificationBuilder
    extends GenericSpecificationBuilder<User>{
    public UserSpecificationBuilder(List<SearchCriteria> params) {
        super(params);
    }
}
