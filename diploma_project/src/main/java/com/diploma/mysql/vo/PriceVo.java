package com.diploma.mysql.vo;

import java.util.List;

public class PriceVo {
    private String productId;
    private List<String> priceList;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<String> getList() {
        return priceList;
    }

    public void setList(List<String> priceList) {
        this.priceList = priceList;
    }
}
