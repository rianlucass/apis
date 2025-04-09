package com.br.datajpa.springdata.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @OneToOne(cascade = CascadeType.ALL)
    private DetalhesLivro detalhesLivro;

    @ManyToMany(mappedBy = "livros")
    private List<Leitor>leitores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public DetalhesLivro getDetalhesLivro() {
        return detalhesLivro;
    }

    public void setDetalhesLivro(DetalhesLivro detalhesLivro) {
        this.detalhesLivro = detalhesLivro;
    }

    public List<Leitor> getLeitores() {
        return leitores;
    }

    public void setLeitores(List<Leitor> leitores) {
        this.leitores = leitores;
    }
}
