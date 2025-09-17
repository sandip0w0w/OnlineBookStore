package com.example.OnlineBookStore.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(
            columnDefinition = "TEXT"
    )
    private String bio;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }


    public Author(String bio, List<Book> books, Long id, String name) {
        this.bio = bio;
        this.books = books;
        this.id = id;
        this.name = name;
    }

    public Author(String name, String bio) {
            this.name = name;
            this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
