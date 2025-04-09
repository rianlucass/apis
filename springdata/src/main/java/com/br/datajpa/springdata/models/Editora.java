package com.br.datajpa.springdata.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "editoras")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String nome;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livros;
}
