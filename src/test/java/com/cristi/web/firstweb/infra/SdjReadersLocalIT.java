package com.cristi.web.firstweb.infra;


import com.cristi.web.firstweb.domain.Reader;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SdjReadersLocalIT {

    public static final String USERNAME = "bonitos";

    @Autowired private SdjReaders sut;
    @Autowired private ReadersSdj sdj;

    @Test
    public void get_should_return_the_user_if_it_exists() {
        sdj.deleteAll();
        Reader expected = new Reader(USERNAME, "Cristi Bo$$", "password");
        sdj.saveAndFlush(expected);
        Optional<Reader> maybeActual = sut.get(USERNAME);
        assertThat(maybeActual.isPresent()).isTrue();
        Reader actual = maybeActual.get();
        assertThat(actual.getFullname()).isEqualTo(expected.getFullname());
        assertThat(actual.getPassword()).isEqualTo(expected.getPassword());
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
    }
}
