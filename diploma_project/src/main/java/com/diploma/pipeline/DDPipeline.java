package com.diploma.pipeline;

import com.diploma.mysql.dao.CatagoryResitory;
import com.diploma.mysql.model.Category;
import org.apache.bcel.generic.FieldOrMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DDPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CatagoryResitory catagoryResitory=(CatagoryResitory) applicationContext.getBean("catagoryResitory");
        for (Map.Entry<String, Object> entry:resultItems.getAll().entrySet()){
            List<Category> categorieList=(List<Category>)entry.getValue();
            List<Category> categories=new ArrayList<Category>();
            for (Category category:categorieList){
                categories.add(category);
                catagoryResitory.save(category);
            }
            catagoryResitory.save(categories);
            System.out.println("cun");
        }
    }
}
