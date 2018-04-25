package com.diploma.service;

import com.diploma.mysql.model.HistoryPrice;

import java.util.List;

public interface ProductService {
    public void saveProduct();

    public List<HistoryPrice> getProductPrice(String productId);
    public void saveProductPrice(HistoryPrice historyPrice);
}
