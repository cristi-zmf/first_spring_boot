package com.cristi.web.firstweb.domain;

import org.junit.Test;

public class BookTest {

    @Test(expected = DomainConstraintViolationException.class)
    public void book_with_mandatory_fields_not_filled_should_throw_domain_constraint() {
        Book.newBook(null, "blabla", null, null, null, null);
    }
}
