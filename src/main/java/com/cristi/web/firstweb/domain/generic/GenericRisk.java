package com.cristi.web.firstweb.domain.generic;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "GENERIC_RISK")
public class GenericRisk {
    @Id
    private String id;

    @ElementCollection()
    @CollectionTable(
            name = "generic_risk_label",
            joinColumns = @JoinColumn(name = "risk_id")
    )
    @Column(name = "LABEL_VALUE")
    private Set<String> labels;

    public GenericRisk(String id, Set<String> labels) {
        this.id = id;
        this.labels = labels;
    }

    //USED BY JPA
    private GenericRisk() {
    }
}
