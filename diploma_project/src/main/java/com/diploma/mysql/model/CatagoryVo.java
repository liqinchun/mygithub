package com.diploma.mysql.model;

import java.util.List;

public class CatagoryVo {
    private int id;
    private String name;
    List<CategoryDescription> categoryDescriptionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryDescription> getCategoryDescriptionList() {
        return categoryDescriptionList;
    }

    public void setCategoryDescriptionList(List<CategoryDescription> categoryDescriptionList) {
        this.categoryDescriptionList = categoryDescriptionList;
    }
}
