package com.br.rianlucas.biblioteca.dtos.request;

import com.br.rianlucas.biblioteca.models.Book;
import com.br.rianlucas.biblioteca.models.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
public class LoanRequestDTO {
    private String bookId;
    private String userId;
    private Date loanDate;
    private Date returnDate;
}
