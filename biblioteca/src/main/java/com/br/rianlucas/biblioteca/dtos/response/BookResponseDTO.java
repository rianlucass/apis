package com.br.rianlucas.biblioteca.dtos.response;

import com.br.rianlucas.biblioteca.models.Loan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {
    private String id;
    private String title;
    private String author;
    private int yearPublication;
    private boolean available;
    private Loan loan;
}
