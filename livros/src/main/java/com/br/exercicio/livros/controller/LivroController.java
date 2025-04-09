package com.br.exercicio.livros.controller;

import com.br.exercicio.livros.DTOs.LivroRequestDTO;
import com.br.exercicio.livros.DTOs.LivroResponseDTO;
import com.br.exercicio.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDTO> criar(@RequestBody LivroRequestDTO dto) {
        LivroResponseDTO criado = livroService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public List<LivroResponseDTO> lista () {
        return livroService.listarLivros();
    }
}
