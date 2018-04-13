package com.diploma;

import com.diploma.mysql.model.Urlvo;
import com.diploma.service.JniteBase;
import com.diploma.service.UrlService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        Urlvo urlvo=new Urlvo();
        urlvo.setUrlId("1");
        urlvo.setName("冰箱");
        urlService.saveUrl(urlvo);
    }
}