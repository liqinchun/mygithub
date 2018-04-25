package com.diploma.service;

import com.diploma.mysql.dao.CatagoryJdbcResitory;
import com.diploma.mysql.model.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CatagoryServiceTest extends JniteBase{

    @Autowired
    private CatagoryService catagoryService;
    @Autowired
    private CatagoryJdbcResitory catagoryJdbcResitory;
    @Test
    public void addCategory() {
        catagoryService.addCategory("图书");
    }

    @Test
    public void addCategoryDescription() {
        catagoryService.addCategoryDescription("图书","青春文学");
    }

    @Test
    public void getAllCatagory() {
    }

    @Test
    public void fun01(){
        List<Category> category= catagoryJdbcResitory.findCategoryByName("青春文学");
        System.out.println(category.get(0));
    }
}