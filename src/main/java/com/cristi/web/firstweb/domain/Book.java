package com.cristi.web.firstweb.domain;

import javax.persistence.*;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Book(String reader, Book book) {
        this.id = book.id;
        this.reader = reader;
        this.isbn = book.isbn;
        this.title = book.title;
        this.author = book.author;
        this.description = book.description;
    }

    public static Book newBook(String reader, String isbn, String author, String description) {
        Book book = new Book();
        book.description = description;
        return book;
    }

    private Book() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return false;
        }
        else {
            Book otherBook = (Book) obj;
            return id.equals(otherBook.id);
        }
    }

    public String getReader() {
        return reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
