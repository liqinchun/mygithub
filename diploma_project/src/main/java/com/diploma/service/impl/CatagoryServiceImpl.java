package com.diploma.service.impl;

import com.diploma.mysql.dao.CatagoryJdbcResitory;
import com.diploma.mysql.dao.CatagoryResitory;
import com.diploma.mysql.dao.CategoryDescriptionResitory;
import com.diploma.mysql.model.Category;
import com.diploma.mysql.model.CategoryDescription;
import com.diploma.service.CatagoryService;
import com.diploma.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryServiceImpl implements CatagoryService {
    @Autowired
    private CatagoryResitory catagoryResitory;
    @Autowired
    private CategoryDescriptionResitory categoryDescriptionResitory;
    @Autowired
    private CatagoryJdbcResitory catagoryJdbcResitory;

    @Override
    public void addCategory(String catelogName) {
        Category catagory=new Category();
        catagory.setId(UUIDUtil.getUUID("CATAGORY"));
        catagory.setName(catelogName);
        catagoryResitory.save(catagory);
    }

    @Override
    public void addCategoryDescription(String name, String description) {
        String catagoryId=catagoryJdbcResitory.findCategoryByName(name).get(0).getId();
        CategoryDescription categoryDescription=new CategoryDescription();
        categoryDescription.setCatelogDescriptionId(UUIDUtil.getUUID("DES"));
        categoryDescription.setCatelogId(catagoryId);
        categoryDescription.setDescription(description);
        categoryDescriptionResitory.save(categoryDescription);
    }

    @Override
    public List<Category> getAllCatagory() {
        return catagoryResitory.findAll();
    }

    @Override
    public List<Category> getCategoryByDescreption(String description) {
        return catagoryJdbcResitory.findCategoryByDestion(description);
    }

    @Override
    public List<Category> findCatagoryByName(String name) {
        return catagoryJdbcResitory.findCategoryByName(name);
    }
}
