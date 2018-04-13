package com.diploma.spider.jingdong;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class AllSortProcessor implements PageProcessor {
    Site site=Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        List<String> urlList=html.xpath("//div[@class=\"w\"]/div[@class=\"main-classify\"]/div[@class=\"list\"]/div[@class=\"category-items\"]" +
                "/div/div/div[@class=\"mc\"]/div[@class=\"items\"]/dl/dd/a/@href").all();
        List<String> name=html.xpath("//div[@class=\"w\"]/div[@class=\"main-classify\"]/div[@class=\"list\"]/div[@class=\"category-items\"]" +
                "/div/div/div[@class=\"mc\"]/div[@class=\"items\"]/dl/dd/a/text()").all();
        if (!urlList.isEmpty()){
            page.addTargetRequests(urlList);
            int i=0;
            for (String u:urlList){
                //这里处理只爬取list开头的接口
                if (u.contains("list")){
                    System.out.println(i);
                    page.putField(u,name.get(i));
                    i++;
                }
            }
        }
        else{
            urlList=html.xpath("//div[@id=\"J_searchWrap\"]/div[@id=\"J_container\"]/div[@id=\"J_main\"]" +
                    "/div[@class=\"m-list\"]/div[@class=\"ml-wrap\"]/div[@id=\"plist\"]/ul/li/div/div[@class=\"p-name\"" +
                    "]/a/@href").all();
             name=html.xpath("//div[@id=\"J_searchWrap\"]/div[@id=\"J_container\"]/div[@id=\"J_main\"]" +
                    "/div[@class=\"m-list\"]/div[@class=\"ml-wrap\"]/div[@id=\"plist\"]/ul/li/div/div[@class=\"p-name\"" +
                    "]/a/em/text()").all();
            if (!urlList.isEmpty()){
                page.addTargetRequests(urlList);
                int i=0;
                for (String url:urlList){
                    page.putField(url,name.get(i++));
                }
            }else {
                urlList = html.xpath("//div[@class=\"w\"]/div[@class=\"detail\"]/div[@id=\"detail\"]/div[@class=\"tab-con\"]/div/div[@class=\"p-parameter\"]/ul/li").all();
                if (!urlList.isEmpty()) {
                    page.addTargetRequests(urlList);
                    int i = 0;
                    for (String url : urlList) {
                        page.putField(i + "+++:", url);
                    }

                }

            }
        }


    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new AllSortProcessor()).addUrl("https://www.jd.com/allSort.aspx").thread(5).run();
    }
}
