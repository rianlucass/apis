package com.br.apirest.biblioteca.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestUsuarioDTO {
    private Long id;
    private String email;
    private String nome;
}
