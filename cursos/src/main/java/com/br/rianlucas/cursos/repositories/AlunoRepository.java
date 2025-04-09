package com.br.rianlucas.cursos.repositories;

import com.br.rianlucas.cursos.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
