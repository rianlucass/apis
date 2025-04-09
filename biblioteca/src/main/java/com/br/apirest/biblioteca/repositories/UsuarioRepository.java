package com.br.apirest.biblioteca.repositories;

import com.br.apirest.biblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
