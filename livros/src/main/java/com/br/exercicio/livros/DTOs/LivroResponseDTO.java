package com.br.exercicio.livros.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroResponseDTO {// para devolver/mostrar dados ao cliente usamos a classe Response
    private Long id;
    private String titulo;
    private String nomeAutor;
}
