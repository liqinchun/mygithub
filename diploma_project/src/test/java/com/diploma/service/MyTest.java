package com.diploma.service;

import com.diploma.mysql.dao.ProductDetailResitory;
import com.diploma.mysql.model.Category;
import com.diploma.util.UUIDUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductDetailResitory productDetailResitory=(ProductDetailResitory)applicationContext.getBean("productDetailResitory");
        CatagoryService catagoryService=(CatagoryService) applicationContext.getBean("catagoryServiceImpl");
        List<String> str=new ArrayList<String>();
        str.add("");
        str.add("青春文学");
        str.add("123");
        for (String s:str){

        }
    }

    @Test
    public void fun01(){
        System.out.println((Object) new Category());
    }
}
