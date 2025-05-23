package com.br.rianlucas.biblioteca.dtos.request;

import com.br.rianlucas.biblioteca.models.Loan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String name;
    private String email;
    private String number;
    private Loan loan;
}
