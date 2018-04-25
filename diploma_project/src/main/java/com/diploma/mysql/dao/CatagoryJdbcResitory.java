package com.diploma.mysql.dao;

import com.diploma.mysql.model.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatagoryJdbcResitory {
    public List<Category> findCategoryByName(String catagoryName);

    public List<Category> findCategoryByDestion(String description);
}
