package com.cristi.web.firstweb.domain;

import java.util.Optional;
import java.util.Set;

public interface Books {
    Set<Book> findAll();

    Optional<Book> get(Long id);

    Set<Book> findByReader(String reader);

    Book add(Book book);
}
