package com.diploma.spider.jingdong;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class ProductDetailProcessor implements PageProcessor {
    Site site=Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        Html html=page.getHtml();

        List<String>urlList = html.xpath("//div[@class=\"w\"]/div[@class=\"detail\"]/div[@id=\"detail\"]/div[@class=\"tab-con\"]/div/div[@class=\"p-parameter\"]/ul/li").all();

        if (!urlList.isEmpty()) {
            page.addTargetRequests(urlList);
            int i = 0;
            for (String url : urlList) {
                page.putField(i + "+++:", url);
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new ProductDetailProcessor()).addUrl("https://item.jd.com/39007186.html" +
                "").thread(5).run();
    }
}
