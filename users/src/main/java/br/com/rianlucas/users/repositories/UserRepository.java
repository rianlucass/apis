package br.com.rianlucas.users.repositories;

import br.com.rianlucas.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
