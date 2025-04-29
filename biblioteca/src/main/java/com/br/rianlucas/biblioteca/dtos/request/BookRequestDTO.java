package com.br.rianlucas.biblioteca.dtos.request;

import com.br.rianlucas.biblioteca.models.Loan;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookRequestDTO {
    private String title;
    private String author;
    private int yearPublication;
    private boolean available;
    private Loan loan;
}
