package com.br.exercicio.livros.controller;

import com.br.exercicio.livros.DTOs.AutorRequestDTO;
import com.br.exercicio.livros.DTOs.AutorResponseDTO;
import com.br.exercicio.livros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDTO> criar(@RequestBody AutorRequestDTO dto) {
        AutorResponseDTO criado = autorService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public List<AutorResponseDTO> listar() {
        return autorService.listarAutores();
    }
}
