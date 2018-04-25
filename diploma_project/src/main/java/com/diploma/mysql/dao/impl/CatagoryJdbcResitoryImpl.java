package com.diploma.mysql.dao.impl;

import com.diploma.mysql.dao.CatagoryJdbcResitory;
import com.diploma.mysql.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("catagoryJdbcResitory")
public class CatagoryJdbcResitoryImpl implements CatagoryJdbcResitory {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> findCategoryByName(String catagoryName) {
        String sql="SELECT * FROM category WHERE NAME=:catagoryName";
        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        nativeQuery.setParameter("catagoryName",catagoryName);
        List<Object[]> tem=nativeQuery.getResultList();
        List<Category> categories=new ArrayList<Category>();
        Category category;
        for (Object[] obj:tem){
            category=new Category();
            category.setId((String)obj[0]);
            category.setName((String)obj[1]);
            category.setUrl((String)obj[2]);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Category> findCategoryByDestion(String content) {
        String sql="SELECT * FROM category WHERE id in (SELECT catelogId FROM category_description WHERE description=:content)";
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter("content",content);
        List<Category> categoryList=query.getResultList();
        return categoryList;
    }
}
