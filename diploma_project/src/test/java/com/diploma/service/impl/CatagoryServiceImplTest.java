package com.diploma.service.impl;

import com.diploma.mysql.model.Category;
import com.diploma.service.CatagoryService;
import com.diploma.service.JniteBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CatagoryServiceImplTest extends JniteBase {

    @Autowired
    private CatagoryService catagoryService;
    @Test
    public void addCategory() {
        catagoryService.addCategory("图书");
    }

    @Test
    public void addCategoryDescription() {
        catagoryService.addCategoryDescription("图书","青春文学");
        catagoryService.addCategoryDescription("图书","小说");
        catagoryService.addCategoryDescription("图书","休闲/爱好");
        catagoryService.addCategoryDescription("图书","文学");
        catagoryService.addCategoryDescription("图书","孕产/胎教");
        catagoryService.addCategoryDescription("图书","艺术");
        catagoryService.addCategoryDescription("图书","动漫/幽默");
        catagoryService.addCategoryDescription("图书","烹饪/美食");
        catagoryService.addCategoryDescription("图书","时尚/美妆");
    }

    @Test
    public void getAllCatagory() {
    }

    @Test
    public void getCategoryByDescription(){
        List<Category> categorie=catagoryService.getCategoryByDescreption("");
        System.out.println();
    }
}