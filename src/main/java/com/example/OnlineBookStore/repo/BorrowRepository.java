package com.example.OnlineBookStore.repo;

import com.example.OnlineBookStore.model.Book;
import com.example.OnlineBookStore.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BorrowRepository  extends JpaRepository<Borrow, Long> {

    boolean existsByBookAndBookStatus(Book book, Borrow.BookStatus status);
    List<Borrow> findByUserId(Long userId);
    List<Borrow> findByBookId(Long bookId);
    List<Borrow> findByBookStatusAndReturnDateBefore(Borrow.BookStatus status, Date date);

}
