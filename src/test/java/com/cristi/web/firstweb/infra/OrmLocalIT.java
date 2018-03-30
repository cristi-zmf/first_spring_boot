package com.cristi.web.firstweb.infra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("H2")
public class OrmLocalIT {

    @Autowired
    EntityManager em;

    @Test
    public void entity_manager_should_load() {
        assertThat(em).isNotNull();
    }
}
