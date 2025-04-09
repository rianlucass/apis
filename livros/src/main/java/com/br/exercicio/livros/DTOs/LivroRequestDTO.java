package com.br.exercicio.livros.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroRequestDTO {//para receber dados do cliente usamos a classe Request
    private String titulo;
    private Long autorId;
}
