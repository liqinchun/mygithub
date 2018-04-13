package com.diploma.spider_project.mysql.dao;

import com.diploma.spider_project.mysql.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,String> {
}
