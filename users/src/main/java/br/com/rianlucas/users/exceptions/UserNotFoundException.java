package br.com.rianlucas.users.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String id) {
        super("User " + id + " not found!");
    }
}
