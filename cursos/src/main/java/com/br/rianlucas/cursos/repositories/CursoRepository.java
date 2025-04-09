package com.br.rianlucas.cursos.repositories;

import com.br.rianlucas.cursos.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
