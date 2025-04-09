package com.br.apirest.biblioteca.controller;

import com.br.apirest.biblioteca.dtos.ResponseUsuarioDTO;
import com.br.apirest.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public List<ResponseUsuarioDTO> listar() {
        return usuarioService.listarUsuarios();
    }

    public ResponseEntity<ResponseUsuarioDTO> criar(@RequestBody ResponseUsuarioDTO usuarioDTO) {
        ResponseUsuarioDTO usuario = usuarioService.salvar(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

}
