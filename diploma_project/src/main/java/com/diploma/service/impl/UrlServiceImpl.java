package com.diploma.service.impl;

import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Service
public class UrlServiceImpl implements UrlService,PageProcessor{
    @Autowired
    private UrlResitory urlResitory;
    @Override
    public void findAllUrl() {
        urlResitory.findAll();
    }

    @Override
    public void process(Page page) {
        
    }

    @Override
    public void saveUrl(Urlvo urlvo){
        urlResitory.save(urlvo);
    }
    @Override
    public Site getSite() {
        return null;
    }
}
