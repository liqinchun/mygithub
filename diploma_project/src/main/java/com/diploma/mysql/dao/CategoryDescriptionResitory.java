package com.diploma.mysql.dao;

import com.diploma.mysql.model.CategoryDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDescriptionResitory extends JpaRepository<CategoryDescription,String> {
}
