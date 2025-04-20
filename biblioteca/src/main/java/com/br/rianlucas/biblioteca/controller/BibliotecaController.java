package com.br.rianlucas.biblioteca.controller;

import com.br.rianlucas.biblioteca.dtos.request.BookRequestDTO;
import com.br.rianlucas.biblioteca.dtos.request.LoanRequestDTO;
import com.br.rianlucas.biblioteca.dtos.request.UserRequestDTO;
import com.br.rianlucas.biblioteca.dtos.response.BookResponseDTO;
import com.br.rianlucas.biblioteca.dtos.response.LoanResponseDTO;
import com.br.rianlucas.biblioteca.dtos.response.UserResponseDTO;
import com.br.rianlucas.biblioteca.services.BookService;
import com.br.rianlucas.biblioteca.services.LoanService;
import com.br.rianlucas.biblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BibliotecaController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LoanService loanService;

    @PostMapping("/books")
    public ResponseEntity<BookResponseDTO> saveBook(@RequestBody BookRequestDTO dto) {
        BookResponseDTO bookCreated = bookService.saveBook(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookCreated);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO dto) {
        UserResponseDTO userCreated = userService.saveUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/books")
    public List<BookResponseDTO> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/loans")
    public ResponseEntity<LoanResponseDTO> registerNewLoan(@RequestBody LoanRequestDTO dto) {
        boolean created = loanService.registerLoan(dto);
        LoanResponseDTO responseDTO = new LoanResponseDTO();
        responseDTO.setBook(responseDTO.getBook());
        responseDTO.setUser(responseDTO.getUser());
        responseDTO.setLoanDate(dto.getLoanDate());
        responseDTO.setReturnDate(dto.getReturnDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    
    @PutMapping("/loans/{id}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable String id, @RequestBody LoanRequestDTO dto) {
        LoanResponseDTO responseDTO = loanService.updateReturnDate(id ,dto.getReturnDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/loans")
    public List<LoanResponseDTO> getAllLoans() {
        return loanService.getAllLoans();
    }

}
