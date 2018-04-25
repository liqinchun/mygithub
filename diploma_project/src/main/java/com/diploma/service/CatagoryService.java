package com.diploma.service;

import com.diploma.mysql.model.Category;

import java.util.List;

public interface CatagoryService {
    public void addCategory(String catelogName);
    public void addCategoryDescription(String name,String description);
    public List<Category> getAllCatagory();
    public List<Category> getCategoryByDescreption(String description);
    public List<Category>   findCatagoryByName(String name);
}
