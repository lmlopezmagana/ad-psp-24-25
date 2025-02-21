package com.salesianos.data.controller;

import com.salesianos.data.dto.CreateUsuarioCmd;
import com.salesianos.data.model.Usuario;
import com.salesianos.data.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario/")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<Usuario> create(
            @RequestBody @Valid CreateUsuarioCmd cmd) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.create(cmd));
    }

}
