package com.diploma.mysql.model;

import javax.persistence.*;

@Entity
@Table(name = "category_description", schema = "compareprice", catalog = "")
public class CategoryDescription {
    private String catelogDescriptionId;
    private String catelogId;
    private String description;

    @Id
    @Column(name = "catelogDescriptionId")
    public String getCatelogDescriptionId() {
        return catelogDescriptionId;
    }

    public void setCatelogDescriptionId(String catelogDescriptionId) {
        this.catelogDescriptionId = catelogDescriptionId;
    }

    @Basic
    @Column(name = "catelogId")
    public String getCatelogId() {
        return catelogId;
    }

    public void setCatelogId(String catelogId) {
        this.catelogId = catelogId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDescription that = (CategoryDescription) o;

        if (catelogDescriptionId != null ? !catelogDescriptionId.equals(that.catelogDescriptionId) : that.catelogDescriptionId != null)
            return false;
        if (catelogId != null ? !catelogId.equals(that.catelogId) : that.catelogId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = catelogDescriptionId != null ? catelogDescriptionId.hashCode() : 0;
        result = 31 * result + (catelogId != null ? catelogId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
