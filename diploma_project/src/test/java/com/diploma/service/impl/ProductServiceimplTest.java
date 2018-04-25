package com.diploma.service.impl;

import com.diploma.service.JniteBase;
import com.diploma.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductServiceimplTest extends JniteBase {

    @Autowired
    private ProductService productService;
    @Test
    public void saveProduct() {
        productService.saveProduct();
    }
}