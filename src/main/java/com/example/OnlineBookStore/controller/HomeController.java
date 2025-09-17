package com.example.OnlineBookStore.controller;

import com.example.OnlineBookStore.DTO.AuthorResponseDTO;
import com.example.OnlineBookStore.DTO.BookRequestDTO;
import com.example.OnlineBookStore.DTO.BooksResponseDTO;
import com.example.OnlineBookStore.DTO.BorrowResponseDTO;
import com.example.OnlineBookStore.model.*;
import com.example.OnlineBookStore.service.BookService;
import com.example.OnlineBookStore.service.BorrowService;
import com.example.OnlineBookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private UserService userService;


    @GetMapping("/book")
    public List<BooksResponseDTO> showBook(){
        return bookService.getBooks();
    }

    @PostMapping("/addbook")
    @PreAuthorize("hasRole('ADMIN')")
    public BookRequestDTO addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return bookService.addBooks(bookRequestDTO);
    }

    @GetMapping("/book/{id}")
    public List<AuthorResponseDTO> authorBooks(@PathVariable Long id ){

        return bookService.seeAuthorBooks(id);
    }

    @GetMapping ("book/borrow/{book_id}")
    public BorrowResponseDTO borrowBooks(@PathVariable Long book_id){
        System.out.println("Inside borrowBooks");
        return borrowService.borrowBook(book_id);
    }

    @GetMapping("book/return/{borrow_id}")
    public BorrowResponseDTO returnBooks(@PathVariable Long borrow_id){
        return borrowService.returnBook(borrow_id);

    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return (String) "user " + user.getName()+" created!";
    }


}
