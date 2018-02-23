package com.cristi.web.firstweb.domain;

import javax.validation.constraints.NotNull;

public abstract class BaseEntity<T extends BaseEntity<T, ID>, ID extends BaseValueObject<ID>> implements Validable<BaseEntity<T, ID>> {
    private Class<T> type;
    @NotNull
    private final ID id;

    protected BaseEntity(Class<T> type, ID id) {
        this.type = type;
        this.id = id;
        validate(this);
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!type.isInstance(obj)) {
            return false;
        }
        T other = type.cast(obj);
        return id.equals(other.getId());
    }
}
