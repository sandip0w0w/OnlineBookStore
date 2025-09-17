package com.example.OnlineBookStore.DTO;

import com.example.OnlineBookStore.model.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorResponseDTO {

    private String name;
    private String bio;
    private List<BooksResponseDTO> book;

    public AuthorResponseDTO() {
    }

    ;

    public AuthorResponseDTO(Author author) {
        this.name = author.getName();
        this.bio = author.getBio();
        this.book = author.getBooks().stream()
                .map(BooksResponseDTO::new)
                .collect(Collectors.toList());

    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<BooksResponseDTO> getBook() {
        return book;
    }

    public void setBook(List<BooksResponseDTO> book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




