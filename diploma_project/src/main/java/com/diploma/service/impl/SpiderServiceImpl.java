package com.diploma.service.impl;

import java.util.List;
import java.util.UUID;

import com.diploma.mysql.dao.UrlResitory;
import com.diploma.mysql.model.Urlvo;
import com.diploma.service.SpiderService;
import com.diploma.spider.MysqlPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

@Service
public class SpiderServiceImpl implements SpiderService,PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    static int i=0;
    public void process(Page page) {
        Html html=page.getHtml();
        List<String> targetUrl;
        List<String> urlName;
        targetUrl=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]"+
                "/div[@class=\"fs-outter\"]/div/div[@class=\"fs-left\"]/div[@class=\"fs-nav-c\"]/div[@class=\"mui-zebra-module\"]/ul/li/a/@href").all();
        urlName=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]"+
                "/div[@class=\"fs-outter\"]/div/div[@class=\"fs-left\"]/div[@class=\"fs-nav-c\"]/div[@class=\"mui-zebra-module\"]/ul/li/a/text()").all();
        //封装Vo
        Urlvo urlvo;
        for (String key:urlName){
            urlvo=new Urlvo();
            urlvo.setUrl(targetUrl.get(i));
            urlvo.setName(key);
            urlvo.setUrlId(UUID.randomUUID().toString());
            page.putField(key, targetUrl.get(i));
            i++;
        }
//        Urlvo urlvo;
//        for (String url:targetUrl){
//            urlvo=new Urlvo();
//            urlvo.setUrlId(UUID.randomUUID().toString());
//            urlvo.setUrl(url);
//            urlvo.setName(urlName.get(i++));
////            urlResitory.save(urlvo);
//
//        }

//        targetUrl=html.xpath("//div[@id=\"bd\"]/div[@class=\"con\"]/div[@id=\"12808\"]" +
//                "/div[@id=\"12810\"]/div/div[@class=\"con shoplist\"]/div[@id=\"search_nature_rg\"]/ul/li/a/@href").all();
//            String price=html.xpath("//*/body/div[@class=\"product_wrapper product_fb\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
//                    "/div[@class=\"sale_box clearfix\"]/div[@class=\"sale_box_left\"]/div[@class=\"price_info clearfix\"]/div[@class=\"price_pc\"]" +
//                    "/div[@class=\"price_d\"]/p[@id=\"dd-price\"]/text()").all().toString();
//
            page.addTargetRequests(targetUrl);



    }

    public Site getSite() {
        return site;
    }

    @Override
    public void SpiderRun(){
        us.codecraft.webmagic.Spider.create(new SpiderServiceImpl()).addPipeline(new MysqlPipeline()).addUrl("https://3c.tmall.com/?spm=875.7931836/B.category2016019.1.7cb44265LOwCNZ&go=appl&acm=lb-zebra-148799-667863.1003.4.708026&scm=1003.4.lb-zebra-148799-667863.OTHER_14561650644158_708026")
                .thread(5).run();
    }

    public static void main(String args[]){
        us.codecraft.webmagic.Spider.create(new SpiderServiceImpl()).addPipeline(new MysqlPipeline()).addUrl("https://3c.tmall.com/?spm=875.7931836/B.category2016019.1.7cb44265LOwCNZ&go=appl&acm=lb-zebra-148799-667863.1003.4.708026&scm=1003.4.lb-zebra-148799-667863.OTHER_14561650644158_708026")
                .thread(5).run();
    }
}
