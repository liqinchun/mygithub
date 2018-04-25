package com.diploma.mysql.dao;

import com.diploma.mysql.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailResitory extends JpaRepository<ProductDetail,String> {
}
