package com.cristi.web.firstweb.domain.local;

import com.cristi.web.firstweb.domain.BaseRisk;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
@Table(name = "SPECIFIC_RISK")
public class SpecificRisk extends BaseRisk {
    private String specificThing;
    private String oeId;

    public SpecificRisk(
            String id, Set<String> labels, String specificThing, String oeId
    ) {
        super(id, labels);
        this.specificThing = specificThing;
        this.oeId = oeId;
    }

    private SpecificRisk() {
        super(null, null);
        specificThing = null;
    }

    public String getSpecificThing() {
        return specificThing;
    }
}
