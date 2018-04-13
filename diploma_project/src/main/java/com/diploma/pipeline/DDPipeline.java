package com.diploma.pipeline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

public class DDPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        for (Map.Entry<String, Object> entry:resultItems.getAll().entrySet()){
            String key=(String) entry.getKey();
            if (key.equals("种类")){
                String catagory=(String) entry.getValue();
            }else if (key.equals("商品")){
                Object product=entry.getValue();
            }


        }

    }
}
