package com.cristi.web.firstweb.infra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SdjBooksLocalIT {

    @Autowired private SdjBooks sut;
    @Autowired private BooksSdj sdj;


    @Test
    public void add_should_persist_correctly_the_entity() {

    }
}
