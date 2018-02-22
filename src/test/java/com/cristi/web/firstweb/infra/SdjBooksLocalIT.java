package com.cristi.web.firstweb.infra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SdjBooksLocalIT {

    private final SdjBooks sut;
    private final BooksSdj sdj;

    public SdjBooksLocalIT(SdjBooks sut, BooksSdj sdj) {
        this.sut = sut;
        this.sdj = sdj;
    }

    @Test
    public void add_should_persist_correctly_the_entity() {

    }
}
