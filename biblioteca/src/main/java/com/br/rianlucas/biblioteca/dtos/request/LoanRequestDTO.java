package com.br.rianlucas.biblioteca.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoanRequestDTO {
    private String bookId;
    private String userId;
    private Date loanDate;
    private Date returnDate;
}
