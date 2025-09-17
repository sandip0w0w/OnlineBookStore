package com.example.OnlineBookStore.DTO;

import com.example.OnlineBookStore.model.Book;

import java.util.Date;
import java.util.List;

public class BookRequestDTO {
  private Book book;
  private String title;
  private String description;
  private Date publicationDate;
  private int quantity;
  private List<AuthorDTO> author;


  public BookRequestDTO(){

  }
    public BookRequestDTO(Book book){
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.publicationDate = book.getPublicationDate();
        this.quantity = book.getQuantity();
        this.author = book.getAuthors().stream()
                .map(authorEntity ->{
                    AuthorDTO authorDTO = new AuthorDTO();
                    authorDTO.setName(authorEntity.getName());
                    authorDTO.setBio(authorEntity.getBio());
                    return authorDTO;
                }).toList();
    }

    public List<AuthorDTO> getAuthor() {
        return this.author;
    }

    public void setAuthor(List<AuthorDTO> author) {
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
