package com.cristi.web.firstweb.domain;

import org.junit.Test;

import static com.cristi.web.firstweb.domain.Book.*;

public class BookTest {

    @Test(expected = DomainConstraintViolationException.class)
    public void book_with_mandatory_fields_not_filled_should_throw_domain_constraint() {
        newBook(null, "blabla", null, null, null, null);
    }

    @Test
    public void book_with_mandatory_fields_filled_should_be_validated() {
        newBook(3L, "blabla", "bla bla", "GOT", "GG Martin", "Cool story bro");
    }
}
