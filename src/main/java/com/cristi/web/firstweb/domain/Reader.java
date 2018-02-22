package com.cristi.web.firstweb.domain;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.Id;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
public class Reader {
    @Id
    private String username;
    private String fullname;
    private String password;

    private Reader() {
    }

    public Reader(String username, String fullname, String password) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
    }
}
