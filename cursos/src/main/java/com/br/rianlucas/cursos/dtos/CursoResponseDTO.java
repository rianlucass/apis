package com.br.rianlucas.cursos.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoResponseDTO {
    private Long id;
    private String nome;
    private int cargaHoraria;
}
