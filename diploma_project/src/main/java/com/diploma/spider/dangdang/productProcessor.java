package com.diploma.spider.dangdang;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class productProcessor implements PageProcessor{
    Site site=Site.me().setSleepTime(1000).setRetryTimes(3);
    @Override
    public void process(Page page) {

        Html html=page.getHtml();
        List<String> price=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"price_info clearfix\"]/div[@id=\"pc-price\"]" +
                "/div[@class=\"price_d\"]/p[@id=\"dd-price\"]/text()").all();

        List<String> picUrl=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"pic_info\"]" +
                "/div[@id=\"largePicDiv\"]/a/img/@src").all();

        List<String> detail=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_content clearfix\"]/div[@id=\"right-content\"]" +
                "/div[@id=\"product_tab\"]/div[@id=\"detail_all\"]/div[@id=\"detail_describe\"]/ul/li/text()").all();
        List<String> catalog=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_content clearfix\"]/div[@id=\"right-content\"]" +
                "/div[@id=\"product_tab\"]/div[@id=\"detail_all\"]/div[@id=\"detail_describe\"]/ul/li/span/a/text()").all();
        List<String> catalog1=html.xpath("//div[@class=\"product_wrapper\"]/div[@id=\"breadcrumb\"]/a").all();


        System.out.println("价格:"+price+"+++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new productProcessor()).addUrl("http://product.dangdang.com/25230126.html").thread(5).run();
    }
}
