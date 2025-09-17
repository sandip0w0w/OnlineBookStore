package com.example.OnlineBookStore.service;

import com.example.OnlineBookStore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    BookRepository bookRepository;


}
