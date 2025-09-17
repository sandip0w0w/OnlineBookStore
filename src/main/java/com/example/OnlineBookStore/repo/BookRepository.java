package com.example.OnlineBookStore.repo;

import com.example.OnlineBookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
