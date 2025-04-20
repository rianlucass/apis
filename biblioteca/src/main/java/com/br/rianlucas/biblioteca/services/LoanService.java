package com.br.rianlucas.biblioteca.services;

import com.br.rianlucas.biblioteca.dtos.request.LoanRequestDTO;
import com.br.rianlucas.biblioteca.dtos.response.LoanResponseDTO;
import com.br.rianlucas.biblioteca.models.Book;
import com.br.rianlucas.biblioteca.models.Loan;
import com.br.rianlucas.biblioteca.repositories.BookRepository;
import com.br.rianlucas.biblioteca.repositories.LoanRepository;
import com.br.rianlucas.biblioteca.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    @Transactional
    public boolean registerLoan(LoanRequestDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());

        if (book.isAvailable()) {
            System.out.println("entrei no if");
            Loan loan = new Loan();
            loan.setBook(book);
            loan.setUser(userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado!")));

            loan.setLoanDate(dto.getLoanDate());
            book.setAvailable(false);

            loanRepository.save(loan);
            return true;
        }

        return false;
    }

    public LoanResponseDTO updateReturnDate(String id, Date returnDate) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Emprestimo não encontrado!"));
        loan.setReturnDate(returnDate);

        loan = loanRepository.save(loan);

        Book book = bookRepository.findById(loan.getBook().getId())
                .orElseThrow(()->
                        new RuntimeException("Livro não encontrado!"));
        book.setAvailable(true);
        bookRepository.save(book);

        LoanResponseDTO responseDTO = new LoanResponseDTO();
        responseDTO.setUser(loan.getUser());
        responseDTO.setBook(loan.getBook());
        responseDTO.setLoanDate(loan.getLoanDate());
        responseDTO.setReturnDate(loan.getReturnDate());

        return responseDTO;
    }

    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll().stream().map(loan -> {
            LoanResponseDTO responseDTO = new LoanResponseDTO();
            responseDTO.setBook(loan.getBook());
            responseDTO.setUser(loan.getUser());
            responseDTO.setId(loan.getId());
            responseDTO.setLoanDate(loan.getLoanDate());
            responseDTO.setReturnDate(loan.getReturnDate());
            return responseDTO;
        }).collect(Collectors.toList());
    }

}
