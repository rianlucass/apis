package com.br.rianlucas.cursos.dtos;

import com.br.rianlucas.cursos.models.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoRequestDTO {
    private String nome;
    private Curso curso;
}
