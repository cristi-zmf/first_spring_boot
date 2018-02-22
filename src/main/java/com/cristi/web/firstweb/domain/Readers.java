package com.cristi.web.firstweb.domain;

import java.util.Optional;

public interface Readers {

    Optional<Reader> get(String username);
}
