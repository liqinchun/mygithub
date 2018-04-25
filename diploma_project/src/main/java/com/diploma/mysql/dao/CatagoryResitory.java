package com.diploma.mysql.dao;

import com.diploma.mysql.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatagoryResitory extends JpaRepository<Category,String> {

}
