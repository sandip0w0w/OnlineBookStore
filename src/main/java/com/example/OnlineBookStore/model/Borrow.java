package com.example.OnlineBookStore.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Date borrowDate;

    private Date returnDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(255) default 'AVAILABLE'")
    private BookStatus bookStatus;

    public enum BookStatus{
        BORROWED,
        RETURNED,
        OVERDUE,
        AVAILABLE
    }

    public Borrow() {}

    public Borrow(Book book, BookStatus bookStatus, Date borrowDate, Long id, Date returnDate, User user) {
        this.book = book;
        this.bookStatus = bookStatus;
        this.borrowDate = borrowDate;
        this.id = id;
        this.returnDate = returnDate;
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
