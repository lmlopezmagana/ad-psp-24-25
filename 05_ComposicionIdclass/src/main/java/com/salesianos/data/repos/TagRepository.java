package com.salesianos.data.repos;

import com.salesianos.data.model.Categoria;
import com.salesianos.data.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository
        extends JpaRepository<Tag, Long> {
}
