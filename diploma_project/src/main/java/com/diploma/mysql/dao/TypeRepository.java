package com.diploma.mysql.dao;

import com.diploma.mysql.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,String> {
}
