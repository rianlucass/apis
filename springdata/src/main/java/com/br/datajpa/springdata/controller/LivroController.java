package com.br.datajpa.springdata.controller;

import com.br.datajpa.springdata.models.Livro;
import com.br.datajpa.springdata.repositories.LivroRepository;
import com.br.datajpa.springdata.service.LivroService;
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

    @GetMapping
    public List<Livro> listarLivro() {
        return livroService.listarLivros();
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

}
