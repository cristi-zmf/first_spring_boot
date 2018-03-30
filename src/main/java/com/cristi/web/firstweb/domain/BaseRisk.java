package com.cristi.web.firstweb.domain;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.AccessType.FIELD;

@Access(FIELD)
@MappedSuperclass
public abstract class BaseRisk {
    @Id
    private String id;
    @ElementCollection()
    @CollectionTable(
            name = "label",
            joinColumns = @JoinColumn(name = "risk_id")
    )
    @Column(name = "LABEL_VALUE")
    private Set<String> labels;

    public BaseRisk(String id, Set<String> labels) {
        this.id = id;
        this.labels = labels;
    }

    //USED BY JPA
    private BaseRisk() {
    }
}
