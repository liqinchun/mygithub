package com.diploma.spider_project.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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
        return Objects.equals(typeId, type.typeId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(typeId);
    }
}
