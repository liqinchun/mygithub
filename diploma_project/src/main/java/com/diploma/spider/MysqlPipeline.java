package com.diploma.spider;

import com.diploma.mysql.dao.CatagoryResitory;
import com.diploma.mysql.dao.ProductDetailResitory;
import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Category;
import com.diploma.mysql.model.ProductDetail;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.CatagoryService;
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

    @Override
    public void process(ResultItems resultItems, Task task) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductDetailResitory productDetailResitory=(ProductDetailResitory)applicationContext.getBean("productDetailResitory");
        CatagoryService catagoryService=(CatagoryService) applicationContext.getBean("catagoryServiceImpl");

        ProductDetail productDetail=null;
        String categoryId=null;
        for (Map.Entry<String, Object> entry:resultItems.getAll().entrySet()){
            if (entry.getKey().equals("productDetail")){
                productDetail=(ProductDetail) entry.getValue();
            }else if(entry.getKey().equals("catagory")){
                List<String> cataList=(List<String>) entry.getValue();
                for(String cata:cataList){
                    List<Category> categorys=catagoryService.findCatagoryByName(cata);
                    if (!categorys.isEmpty()){
                        categoryId=categorys.get(0).getId();
                    }
                }
                productDetail.setCatagoryId(categoryId);
            }
        }
        productDetailResitory.save(productDetail);
    }


    public List autoSaveProduct(String content){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CatagoryService catagoryService=(CatagoryService) applicationContext.getBean("catagoryService");
        catagoryService.getCategoryByDescreption(content);
        return null;
    }

}
