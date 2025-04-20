package com.br.rianlucas.biblioteca.repositories;

import com.br.rianlucas.biblioteca.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, String> {
}
