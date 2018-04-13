package com.diploma.spider;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;


public class UrlSpider implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        List<String> targetUrl;
        List<String> urlName;
        Selectable url=page.getUrl();
        targetUrl=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]"+
                "/div[@class=\"fs-outter\"]/div/div[@class=\"fs-left\"]/div[@class=\"fs-nav-c\"]/div[@class=\"mui-zebra-module\"]/ul/li/a/@href").all();
        urlName=html.xpath("//div[@id=\"mallPage\"]/div[@id=\"content\"]/div[@class=\"mui-zebra-page\"]"+
                "/div[@class=\"fs-outter\"]/div/div[@class=\"fs-left\"]/div[@class=\"fs-nav-c\"]/div[@class=\"mui-zebra-module\"]/ul/li/a/text()").all();
        page.addTargetRequests(targetUrl);

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        us.codecraft.webmagic.Spider.create(new DDSpider()).addUrl("https://3c.tmall.com/?spm=875.7931836/B.category2016019.1.7cb44265LOwCNZ&go=appl&acm=lb-zebra-148799-667863.1003.4.708026&scm=1003.4.lb-zebra-148799-667863.OTHER_14561650644158_708026").thread(5).run();
    }
}
