package com.br.datajpa.springdata.repositories;

import com.br.datajpa.springdata.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByTitulo(String titulo);

    List<Livro> findByTituloContaining(String parte);

    List<Livro> findByAutorNome(String nomeAutor);

    List<Livro> findByEditoraNomeOrderByTituloAsc(String editora);


}
