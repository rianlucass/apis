package br.com.rianlucas.users.infra;

import br.com.rianlucas.users.exceptions.UserNotFoundException;
import br.com.rianlucas.users.exceptions.UserResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends RuntimeException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserResponseError> exceptionUserNotFound(UserNotFoundException exception) {
        UserResponseError responseError = new UserResponseError(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<UserResponseError>> handleValidationErrors(MethodArgumentNotValidException exception) {
        List<UserResponseError> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new UserResponseError(HttpStatus.BAD_REQUEST, error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }
}
