package com.br.exercicio.livros.service;

import com.br.exercicio.livros.DTOs.LivroRequestDTO;
import com.br.exercicio.livros.DTOs.LivroResponseDTO;
import com.br.exercicio.livros.models.Autor;
import com.br.exercicio.livros.models.Livro;
import com.br.exercicio.livros.repositories.AutorRepository;
import com.br.exercicio.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;

    //----Etapas para salvar-----
    //Buscar o autor pelo ID
    //Criar o objeto livro e salvar no banco
    //montar dto de resposta
    public LivroResponseDTO salvar(LivroRequestDTO dto) {
        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor nao encontrado"));

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(autor);
        livro = livroRepository.save(livro);

        LivroResponseDTO responseDTO = new LivroResponseDTO();
        responseDTO.setId(livro.getId());
        responseDTO.setTitulo(livro.getTitulo());
        responseDTO.setNomeAutor(livro.getAutor().getNome());

        return responseDTO;
    }

    public List<LivroResponseDTO> listarLivros() {
        return livroRepository.findAll().stream().map(livro -> {
            LivroResponseDTO dto = new LivroResponseDTO();
            dto.setId(livro.getId());
            dto.setTitulo(livro.getTitulo());
            dto.setNomeAutor(livro.getAutor().getNome());
            return dto;
        }).collect(Collectors.toList());
    }

}
