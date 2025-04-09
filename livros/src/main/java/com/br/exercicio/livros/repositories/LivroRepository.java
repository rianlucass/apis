package com.br.exercicio.livros.repositories;

import com.br.exercicio.livros.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
