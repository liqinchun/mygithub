package com.diploma.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="type")
@Entity
public class Type {
    private String typeId;

    @Id
    @Column(name = "typeId")
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (typeId != null ? !typeId.equals(type.typeId) : type.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return typeId != null ? typeId.hashCode() : 0;
    }
}
