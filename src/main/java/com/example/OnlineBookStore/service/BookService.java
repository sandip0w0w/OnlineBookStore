package com.example.OnlineBookStore.service;

import com.example.OnlineBookStore.DTO.AuthorResponseDTO;
import com.example.OnlineBookStore.DTO.BookRequestDTO;
import com.example.OnlineBookStore.DTO.BooksResponseDTO;
import com.example.OnlineBookStore.config.AuthUtil;
import com.example.OnlineBookStore.model.*;
import com.example.OnlineBookStore.repo.AuthorRepository;
import com.example.OnlineBookStore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AuthUtil authUtil;


    public List<BooksResponseDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BooksResponseDTO::new)
                .toList();
    }

    public BookRequestDTO addBooks(BookRequestDTO bookRequestDTO) {
        User currentUser = authUtil.getCurrentUser();
        System.out.println(currentUser.getRole().name());
            Book book = new Book();
            book.setTitle(bookRequestDTO.getTitle());
            book.setDescription(bookRequestDTO.getDescription());
            book.setPublicationDate(bookRequestDTO.getPublicationDate());
            book.setQuantity(bookRequestDTO.getQuantity());

            List<Author> authorList = bookRequestDTO.getAuthor().stream()
                    .map(authorName -> {
                        Optional<Author> existingAuthor = authorRepository.findByName(authorName.getName());
                        if (existingAuthor.isPresent()) {
                            return existingAuthor.get();
                        } else {
                            Author author = new Author();
                            author.setName(authorName.getName());
                            author.setBio(authorName.getBio());
                            return authorRepository.save(author);
                        }
                    }).toList();
            book.setAuthors(authorList);
            Book saved = bookRepository.save(book);
            return new BookRequestDTO(saved);




    }

    public List<AuthorResponseDTO> seeAuthorBooks(Long id) {
        Optional<Author> author  = authorRepository.findById(id);
        return  author.stream()
                .map(AuthorResponseDTO::new)
                .toList();

    }
}
