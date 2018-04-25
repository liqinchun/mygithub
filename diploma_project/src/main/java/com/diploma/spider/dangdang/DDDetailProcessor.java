package com.diploma.spider.dangdang;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class DDDetailProcessor implements PageProcessor {
    Site site=Site.me().setSleepTime(3).setSleepTime(1000);
    @Override
    public void process(Page page) {

        Html html=page.getHtml();
        List<String> targetUrl=html.xpath("//div[@id=\"bd\"]/div[@class=\"con\"]/div[@id=\"12808\"]" +
                        "/div[@id=\"12810\"]/div/div[@class=\"con shoplist\"]/div[@id=\"search_nature_rg\"]/ul/li/a/@href").all();
                if (!targetUrl.isEmpty()) {
                    page.addTargetRequests(targetUrl);

                }else {
                    //价格
                    List<String> price=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                            "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"price_info clearfix\"]/div[@id=\"pc-price\"]" +
                            "/div[@class=\"price_d\"]/p[@id=\"dd-price\" ]/text()").all();

                    page.putField("价格",price);
                    //title
                    List<String> title=html.xpath("//div").all();
                }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
