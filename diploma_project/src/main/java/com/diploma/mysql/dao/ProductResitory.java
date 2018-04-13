package com.diploma.mysql.dao;

import com.diploma.mysql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductResitory extends JpaRepository<Product,String> {
}
