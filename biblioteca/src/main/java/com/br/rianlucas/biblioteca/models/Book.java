package com.br.rianlucas.biblioteca.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String author;

    private int yearPublication;

    private boolean available;

    @OneToMany(mappedBy = "book")
    private List<Loan> loan;
}
