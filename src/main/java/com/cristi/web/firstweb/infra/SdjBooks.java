package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.Book;
import com.cristi.web.firstweb.domain.Books;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class SdjBooks implements Books {

    private final BooksSdj sdj;

    public SdjBooks(BooksSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Set<Book> findByReader(String reader) {
        return sdj.findByReader(reader);
    }

    @Override
    public Book add(Book book) {
        return sdj.save(book);
    }
}
