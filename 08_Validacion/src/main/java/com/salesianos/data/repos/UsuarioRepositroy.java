package com.salesianos.data.repos;

import com.salesianos.data.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositroy
    extends JpaRepository<Usuario, Long> {

    boolean existsByUsername(String username);

}
