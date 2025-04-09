package com.br.datajpa.springdata.repositories;

import com.br.datajpa.springdata.models.Leitor;
import com.br.datajpa.springdata.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<Leitor, Long> {
    Leitor findByLivrosTituloContaining(String palavra);
}
