package com.br.rianlucas.biblioteca.repositories;

import com.br.rianlucas.biblioteca.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoanRepository extends JpaRepository<Loan, String> {
}
