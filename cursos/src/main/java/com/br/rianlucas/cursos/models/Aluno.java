package com.br.rianlucas.cursos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(nullable = false)
    @Getter
    @Setter
    @ManyToOne
    private Curso curso;
}
