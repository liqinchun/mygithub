package com.diploma.service;

import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Type;
import com.diploma.service.impl.SpiderServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;


public class TypeServiceTest extends JniteBase implements PageProcessor {

    @Autowired
    TypeService typeService;
    @Autowired
    private UrlResitory urlResitory;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Test
    public void getAllType() {
       List<Type> typeList= typeService.getAllType();
    }

    @Override
    public void process(Page page) {
        urlResitory.getOne("");
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void fun01(){
        us.codecraft.webmagic.Spider.create(new SpiderServiceImpl()).addUrl("https://detail.tmall.com/item.htm?id=562980660942&spm=a1z09.2.0.0.597e2e8dIsZULF&_u=41of5o1i36a2")
                .thread(1).run();
    }
}