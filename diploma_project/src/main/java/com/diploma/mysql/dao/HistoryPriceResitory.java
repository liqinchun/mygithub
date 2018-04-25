package com.diploma.mysql.dao;

import com.diploma.mysql.model.HistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryPriceResitory extends JpaRepository<HistoryPrice,String>{

    public List<HistoryPrice> findByProductId(String productId);
}
