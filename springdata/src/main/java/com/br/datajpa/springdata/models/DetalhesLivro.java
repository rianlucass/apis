package com.br.datajpa.springdata.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "detalhesLivros")
public class DetalhesLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int numeroPaginas;

    @Column(nullable = false)
    private String idioma;

    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
