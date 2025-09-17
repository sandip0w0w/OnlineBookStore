package com.example.OnlineBookStore.model;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(
    columnDefinition = "TEXT"
    )
    private String description;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")

    )
    private List<Author> authors;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrow;

    public Book() {
    }

    public Book(List<Author> authors, String description, Long id,
                Date publicationDate,
                int quantity,
                String title,
                List<Borrow> borrow) {
        this.authors = authors;
        this.description = description;
        this.id = id;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
        this.title = title;
        this.borrow = borrow;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }
}
