package com.diploma.spider.jingdong;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class JDProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        List<String> urlList=html.xpath("//div[@id=\"app\"]/div[@class=\"fs\"]/div[@class=\"grid_c1 fs_inner\"]/" +
                "div[@class=\"fs_col1\"]/div[@id=J_cate]/ul[@class=\"JS_navCtn cate_menu\"]/li/a/@href").all();
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String args[]){
        Spider.create(new JDProcessor()).addUrl("https://www.jd.com/").thread(5).run();
    }
}
