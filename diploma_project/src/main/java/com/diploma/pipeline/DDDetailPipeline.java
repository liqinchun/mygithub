package com.diploma.pipeline;

import com.diploma.mysql.model.Category;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DDDetailPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry:resultItems.getAll().entrySet()){
            List<String> price=(List<String>) entry.getValue();
            System.out.println(price);
        }
    }
}
