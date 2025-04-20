package com.br.rianlucas.biblioteca.dtos.response;

import com.br.rianlucas.biblioteca.models.Loan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private String number;
    private Loan loan;
}
