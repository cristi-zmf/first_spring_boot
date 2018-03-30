package com.cristi.web.firstweb.domain;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
public class Reader {
    @Id
    private String username;
    @Column(name = "FULL_NAME")
    private String fullname;
    private String password;

    private Reader() {
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public Reader(String username, String fullname, String password) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
    }
}
