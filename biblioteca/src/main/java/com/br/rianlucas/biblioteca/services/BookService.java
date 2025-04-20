package com.br.rianlucas.biblioteca.services;

import com.br.rianlucas.biblioteca.dtos.request.BookRequestDTO;
import com.br.rianlucas.biblioteca.dtos.response.BookResponseDTO;
import com.br.rianlucas.biblioteca.models.Book;
import com.br.rianlucas.biblioteca.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookResponseDTO> getAllBook() {
        return bookRepository.findAll().stream().map(book -> {
            BookResponseDTO responseDTO = new BookResponseDTO();
            responseDTO.setId(book.getId());
            responseDTO.setAuthor(book.getAuthor());
            responseDTO.setTitle(book.getTitle());
            responseDTO.setYearPublication(book.getYearPublication());
            responseDTO.setAvailable(book.isAvailable());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public BookResponseDTO saveBook(BookRequestDTO dto) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setYearPublication(dto.getYearPublication());
        book.setAvailable(dto.isAvailable());
        book = bookRepository.save(book);

        BookResponseDTO responseDTO = new BookResponseDTO();
        responseDTO.setTitle(book.getTitle());
        responseDTO.setAuthor(book.getAuthor());
        responseDTO.setAvailable(book.isAvailable());
        responseDTO.setYearPublication(book.getYearPublication());
        return responseDTO;
    }
/*
    public boolean checkAvailability(String id) {
        System.out.println(id);
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        return book.isAvailable();
    }*/
}
