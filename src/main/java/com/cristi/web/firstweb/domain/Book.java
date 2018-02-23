package com.cristi.web.firstweb.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static java.lang.String.format;
import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
public class Book implements Validable<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private Long id;
    @NotBlank private String reader;
    private String isbn;
    @NotBlank private String title;
    @NotBlank private String author;
    private String description;

    public Book(String reader, Book book) {
        this.id = book.id;
        this.reader = reader;
        this.isbn = book.isbn;
        this.title = book.title;
        this.author = book.author;
        this.description = book.description;
    }

    private Book(Long id, String reader, String isbn, String title, String author, String description) {
        this.id = id;
        this.reader = reader;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        validate(this);
    }

    public static Book newBook(Long id, String reader, String isbn, String title, String author, String description) {
        return new Book(id, reader, isbn, title, author, description);
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
    @Override
    public String toString() {
        return format("[%s: %s]", Book.class.getSimpleName(), id);
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
