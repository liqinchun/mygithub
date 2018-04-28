package com.diploma.service.impl;

import com.diploma.mysql.dao.CatagoryResitory;
import com.diploma.mysql.dao.HistoryPriceResitory;
import com.diploma.mysql.dao.ProductDetailResitory;
import com.diploma.mysql.dao.ProductResitory;
import com.diploma.mysql.model.Category;
import com.diploma.mysql.model.HistoryPrice;
import com.diploma.mysql.model.ProductDetail;
import com.diploma.mysql.vo.PriceVo;
import com.diploma.pipeline.DDDetailPipeline;
import com.diploma.service.ProductService;
import com.diploma.spider.dangdang.DDDetailProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private CatagoryResitory catagoryResitory;
    @Autowired
    private HistoryPriceResitory historyPriceResitory;
    @Autowired
    private ProductDetailResitory productDetailResitory;
    @Override
    public void saveProduct() {
        //从每个分类总取出url爬取
        List<Category> categoryList=catagoryResitory.findAll();
        for (Category category:categoryList){
            Spider.create(new DDDetailProcessor()).addPipeline(new DDDetailPipeline()).addUrl(category.getUrl()).thread(5).run();
        }
    }

    @Override
    public List<HistoryPrice> getProductPrice(String productId) {
        List<HistoryPrice> historyPrices=historyPriceResitory.findByProductId(productId);
        return historyPrices;
    }

    @Override
    public void saveProductPrice(HistoryPrice historyPrice) {
        historyPriceResitory.save(historyPrice);
    }

    @Override
    public List<ProductDetail> findProductByKeyWord(String keyWord) {
        return productDetailResitory.findAll();
    }

    @Override
    public ProductDetail getProduct(String productId) {
        return  productDetailResitory.findOne(productId);
    }
}
