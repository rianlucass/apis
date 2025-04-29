package br.com.rianlucas.users.controllers;

import br.com.rianlucas.users.dtos.requests.UserRequestDTO;
import br.com.rianlucas.users.dtos.responses.UserResponseDTO;
import br.com.rianlucas.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDTO getById(@PathVariable String id) {
        return userService.getByIdUsers(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> resgisterUsers(@Valid @RequestBody UserRequestDTO requestDTO) {
        UserResponseDTO responseDTO = userService.registerUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
