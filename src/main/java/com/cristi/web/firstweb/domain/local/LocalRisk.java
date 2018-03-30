package com.cristi.web.firstweb.domain.local;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
@Table(name = "LOCAL_RISKS_VIEW")
@Immutable
public class LocalRisk {
    @Id
    private String riskId;
    @ElementCollection
    @CollectionTable(
            name = "local_risk_label",
            joinColumns = @JoinColumn(name = "risk_id")
    )
    @Column(name = "RISK_LABEL")
    private Set<String> labelValue;
    private String oeId;

    private LocalRisk() {
    }

    public String getRiskId() {
        return riskId;
    }

    public Set<String> getLabelValue() {
        return labelValue;
    }

    public String getOeId() {
        return oeId;
    }
}
