package com.example.OnlineBookStore.DTO;

import com.example.OnlineBookStore.model.Author;
import com.example.OnlineBookStore.model.Book;

import java.util.Date;
import java.util.List;

public class BooksResponseDTO {
    private Book book;
    private String title;
    private String description;
    private Date publicationDate;
    private int quantity;
    private List<String> author;


    public BooksResponseDTO(){}

    public BooksResponseDTO(Book book){
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.publicationDate = book.getPublicationDate();
        this.quantity = book.getQuantity();
        this.author = book.getAuthors().stream()
                .map(Author:: getName)
                .toList();
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
