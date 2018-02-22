package com.cristi.web.firstweb.infra;

import com.cristi.web.firstweb.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BooksSdj extends JpaRepository<Book, Long> {

    Set<Book> findByReader (String reader);
}
