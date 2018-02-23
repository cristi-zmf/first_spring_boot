package com.cristi.web.firstweb.domain;

import javax.validation.ConstraintViolation;

public class DomainConstraintViolationException extends RuntimeException {

    public DomainConstraintViolationException(String message) {
        super(message);
    }
}
