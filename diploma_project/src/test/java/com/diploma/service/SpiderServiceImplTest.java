package com.diploma.service;

import com.diploma.mysql.dao.TypeRepository;
import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Type;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.impl.SpiderServiceImpl;
import com.diploma.spider.MysqlPipeline;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class SpiderServiceImplTest extends JniteBase {
    @Autowired
    private SpiderService spiderService;
    @Autowired
    private UrlService urlService;
    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void fun01(){
        spiderService.SpiderRun();
        System.out.println(1);
    }

    @Test
    public void saveUrl(){
        Urlvo urlvo=new Urlvo();
        urlvo.setUrlId("2");
        urlvo.setName("冰箱");
//        urlvo.setUrl("//list.tmall.com/search_product.htm?cat=50918004&acm=lb-zebra-24139-328537.1003.4.455785&scm=1003.4.lb-zebra-24139-328537.OTHER_14458832193540_455785");
        urlService.saveUrl(urlvo);
    }
    @Test
    public void fun03(){
        Type type=new Type();
        type.setTypeId("6");
        typeRepository.save(type);
    }
}
