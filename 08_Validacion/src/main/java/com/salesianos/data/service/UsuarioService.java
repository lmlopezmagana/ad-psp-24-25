package com.salesianos.data.service;

import com.salesianos.data.dto.CreateUsuarioCmd;
import com.salesianos.data.model.Usuario;
import com.salesianos.data.repos.UsuarioRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepositroy usuarioRepositroy;


    public Usuario create(CreateUsuarioCmd newUser) {
        return usuarioRepositroy.save(
                Usuario.builder()
                        .username(newUser.username())
                        .password(newUser.password()) // Habría que codificar la contraseña
                        .build()
        );
    }

}
