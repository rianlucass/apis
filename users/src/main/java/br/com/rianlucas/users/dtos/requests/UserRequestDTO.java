package br.com.rianlucas.users.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UserRequestDTO(
        @NotBlank(message = "This field cannot be empty")
        @Size(min = 3, message = "Minimum character allowed is three")
        String name,

        @NotBlank(message = "This field cannot be empty")
        @Email(message = "E-mail invalid")
        String email,

        @NotBlank(message = "This field cannot be empty")
        @Size(min = 6, message = "Minimum character allowed is six")
        String password
) { }
