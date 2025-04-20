package com.br.rianlucas.biblioteca.repositories;

import com.br.rianlucas.biblioteca.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
