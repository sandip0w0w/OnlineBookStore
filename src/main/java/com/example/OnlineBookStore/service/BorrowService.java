package com.example.OnlineBookStore.service;

import com.example.OnlineBookStore.DTO.BorrowResponseDTO;
import com.example.OnlineBookStore.config.AuthUtil;
import com.example.OnlineBookStore.model.Book;
import com.example.OnlineBookStore.model.Borrow;
import com.example.OnlineBookStore.model.User;
import com.example.OnlineBookStore.model.UserPrincipal;
import com.example.OnlineBookStore.repo.BookRepository;
import com.example.OnlineBookStore.repo.BorrowRepository;
import com.example.OnlineBookStore.repo.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class BorrowService {

    private  BorrowRepository borrowRepository;
    private  BookRepository bookRepository;
    private  UserRepository userRepository;
    private AuthUtil authUtil;

    public BorrowService(BorrowRepository borrowRepository,
                         BookRepository bookRepository,
                         UserRepository userRepository,
                         AuthUtil authUtil) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.authUtil = authUtil;
    }


    public BorrowResponseDTO borrowBook(Long bookId) {

        System.out.println("Inside Borrow Book Service");
        User currentUser = authUtil.getCurrentUser();
        System.out.println("User authenticated");

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        boolean alreadyBorrowed = borrowRepository.existsByBookAndBookStatus(book, Borrow.BookStatus.BORROWED);
        if (alreadyBorrowed){
            throw new RuntimeException("Book is already borrowed");
        }

        Borrow borrow = new Borrow();
        borrow.setUser(currentUser);
        borrow.setBook(book);
        borrow.setBorrowDate(new Date(System.currentTimeMillis()));
        borrow.setBookStatus(Borrow.BookStatus.BORROWED);

        borrowRepository.save(borrow);

        return new BorrowResponseDTO(
                borrow.getBook().getTitle(),
                borrow.getBorrowDate() != null ? borrow.getBorrowDate().toString() : null,
                borrow.getReturnDate() != null ? borrow.getReturnDate().toString() : null,
                borrow.getBookStatus().name(),
                borrow.getUser().getName()

        );

    }

    public BorrowResponseDTO returnBook(Long borrowId){

        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not Found"));
        borrow.setReturnDate(new Date(System.currentTimeMillis()));
        borrow.setBookStatus(Borrow.BookStatus.RETURNED);
        borrowRepository.save(borrow);
        return new BorrowResponseDTO(
                borrow.getBook().getTitle(),
                borrow.getBorrowDate() != null ? borrow.getBorrowDate().toString() : null,
                borrow.getReturnDate() != null ? borrow.getBorrowDate().toString() : null,
                borrow.getBookStatus().name(),
                borrow.getUser().getName()

        );
    }
}
