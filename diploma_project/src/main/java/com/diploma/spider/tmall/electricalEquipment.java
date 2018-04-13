package com.diploma.spider.tmall;

import com.gargoylesoftware.htmlunit.html.HtmlListing;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class electricalEquipment implements PageProcessor{

    Site site=Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        List<String> urlList=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]/div[@class=\"fs-outter\"]" +
                "/div[@class=\"fs-container\"]/div[@class=\"fs-left\"]/div[@id=\"J_fs_nav\"]/div[@id=\"J_101\"]/ul/li/a/@href").all();
        List<String> urlName=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]/div[@class=\"fs-outter\"]" +
                "/div[@class=\"fs-container\"]/div[@class=\"fs-left\"]/div[@id=\"J_fs_nav\"]/div[@id=\"J_101\"]/ul/li/a/text()").all();
        int i=0;
        if (!urlList.isEmpty()){
            for (String name:urlName){
                page.putField(name,urlList.get(i++));
            }
            page.addTargetRequests(urlList);
        }else{
            urlList=html.xpath("//div[@class=\"page\"]").all();
//            urlList=html.xpath("//div[@class=\"page\"]/div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"main      bts-61 \"]/div[@id=\"J_ItemList\"]" +
//                    "/div[@class=\"product  \"]/div[@class=\"product-iWrap\"]/div[@class=\"productPrice\"]/em/text()").all();

            page.putField("price",urlList);
        }


    }



    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String args[]){

        Spider.create(new electricalEquipment()).addUrl("https://3c.tmall.com/").thread(5).run();
    }
}
