package com.salesianostriana.dam.restquerylang.query;

import com.salesianostriana.dam.restquerylang.util.SearchCriteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@AllArgsConstructor
public abstract class GenericSpecificationBuilder<U> {

    private List<SearchCriteria> params;


    public Specification<U> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification<U> result = build(params.get(0));

        for(int i = 1; i < params.size(); i++) {
            result = result.and(build(params.get(i)));
        }


        return result;
    }

    private Specification<U> build(SearchCriteria criteria) {
        return new Specification<U>() {
            @Override
            public Predicate toPredicate(Root<U> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (criteria.operation().equalsIgnoreCase(">")) {
                    return builder.greaterThanOrEqualTo(
                            root.<String> get(criteria.key()), criteria.value().toString());
                }
                else if (criteria.operation().equalsIgnoreCase("<")) {
                    return builder.lessThanOrEqualTo(
                            root.<String> get(criteria.key()), criteria.value().toString());
                }
                else if (criteria.operation().equalsIgnoreCase(":")) {
                    if (root.get(criteria.key()).getJavaType() == String.class) {
                        return builder.like(
                                root.<String>get(criteria.key()), "%" + criteria.value() + "%");
                    } else {
                        return builder.equal(root.get(criteria.key()), criteria.value());
                    }
                }
                return null;
            }
        };
    }

}
