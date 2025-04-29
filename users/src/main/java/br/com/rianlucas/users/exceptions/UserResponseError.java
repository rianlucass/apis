package br.com.rianlucas.users.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseError {
    private HttpStatus status;
    private String message;
}
