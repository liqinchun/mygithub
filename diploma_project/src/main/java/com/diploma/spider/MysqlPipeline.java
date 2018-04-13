package com.diploma.spider;

import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Urlvo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class MysqlPipeline implements Pipeline{
    static List<Urlvo> urlvos=new ArrayList<Urlvo>();
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UrlResitory urlResitory=(UrlResitory)applicationContext.getBean("urlResitory");
        System.out.println("+++++++++++++++++++++++++++++++++++"+resultItems);
        Map map=resultItems.getAll();
        Urlvo urlvo;
        for(Map.Entry<String, Object> entry : resultItems.getAll().entrySet()){
            urlvo=new Urlvo();
            String key=entry.getKey();
            Object value=entry.getValue();
            urlvo.setUrlId(UUID.randomUUID().toString());
            urlvo.setName(key);
            urlvo.setUrl(value.toString());
            urlResitory.findAll();
            urlResitory.save(urlvo);
            System.out.println(value);
        }
    }
     public void saveUrl(){
//        urlResitory.save(urlvos);
    }
}
