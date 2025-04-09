package com.br.exercicio.livros.repositories;

import com.br.exercicio.livros.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
