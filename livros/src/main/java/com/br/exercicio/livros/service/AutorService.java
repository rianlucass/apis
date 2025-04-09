package com.br.exercicio.livros.service;

import com.br.exercicio.livros.DTOs.AutorRequestDTO;
import com.br.exercicio.livros.DTOs.AutorResponseDTO;
import com.br.exercicio.livros.models.Autor;
import com.br.exercicio.livros.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor = autorRepository.save(autor);

        AutorResponseDTO responseDTO = new AutorResponseDTO();
        responseDTO.setId(autor.getId());
        responseDTO.setNome(autor.getNome());

        return responseDTO;
    }

    public List<AutorResponseDTO> listarAutores() {
        return autorRepository.findAll().stream().map(autor -> {
            AutorResponseDTO dto = new AutorResponseDTO();
            dto.setId(autor.getId());
            dto.setNome(autor.getNome());
            return dto;
        }).collect(Collectors.toList());
    }
}
