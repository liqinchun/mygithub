package com.diploma.service;

import com.diploma.util.UUIDUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class MyTest {
    @Test
    public void test01(){

        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testUUID(){
        System.out.println(UUIDUtil.getUUID().length());
        System.out.println(UUIDUtil.getUUID("Catagory").length());

    }
}
