package com.salesianostriana.dam.restquerylang.service;

import com.salesianostriana.dam.restquerylang.model.User;
import com.salesianostriana.dam.restquerylang.model.UserRepository;
import com.salesianostriana.dam.restquerylang.query.UserSpecificationBuilder;
import com.salesianostriana.dam.restquerylang.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> search(List<SearchCriteria> searchCriteriaList) {

        UserSpecificationBuilder userSpecificationBuilder
                = new UserSpecificationBuilder(searchCriteriaList);

        Specification<User> where = userSpecificationBuilder.build();

        return userRepository.findAll(where);
    }

}
