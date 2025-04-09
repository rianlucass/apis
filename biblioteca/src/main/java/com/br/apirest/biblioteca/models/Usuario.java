package com.br.apirest.biblioteca.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(unique = true, nullable = false, length = 200)
    private String email;

    @Setter
    @Column(nullable = false, length = 200)
    private String nome;

}
