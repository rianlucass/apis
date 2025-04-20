package com.br.rianlucas.biblioteca.dtos.response;

import com.br.rianlucas.biblioteca.models.Book;
import com.br.rianlucas.biblioteca.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoanResponseDTO {
    private String id;
    private Book book;
    private User user;
    private Date loanDate;
    private Date returnDate;

}
