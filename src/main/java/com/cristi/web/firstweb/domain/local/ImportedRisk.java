package com.cristi.web.firstweb.domain.local;

import com.cristi.web.firstweb.domain.Validable;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static javax.persistence.AccessType.FIELD;

@Entity
@Access(FIELD)
@Table(name = "IMPORTED_RISK")
public class ImportedRisk implements Validable<ImportedRisk> {
    @Id
    private String id;
    @NotNull
    private String parentRisk;
    private String oeId;


    public ImportedRisk(String id, String parentRisk, String oeId) {
        this.id = id;
        this.parentRisk = parentRisk;
        this.oeId = oeId;
        validate(this);
    }

    private ImportedRisk() {
        oeId = null;
        parentRisk = null;
    }
}
