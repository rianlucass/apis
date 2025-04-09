package com.br.datajpa.springdata.service;

import com.br.datajpa.springdata.models.Livro;
import com.br.datajpa.springdata.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }
}
