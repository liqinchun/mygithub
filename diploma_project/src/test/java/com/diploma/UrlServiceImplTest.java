package com.diploma;

import com.diploma.mysql.dao.ProductDetailResitory;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.CatagoryService;
import com.diploma.service.JniteBase;
import com.diploma.service.UrlService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UrlServiceImplTest extends JniteBase {

    @Autowired
    private UrlService urlService;
    @Test
    public void findAllUrl() {
        urlService.findAllUrl();
    }

    @Test
    public void saveUrl(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductDetailResitory productDetailResitory=(ProductDetailResitory)applicationContext.getBean("productDetailResitory");
        CatagoryService catagoryService=(CatagoryService) applicationContext.getBean("catagoryService");
    }
}