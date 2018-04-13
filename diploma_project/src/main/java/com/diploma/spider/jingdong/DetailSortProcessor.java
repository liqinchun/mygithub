package com.diploma.spider.jingdong;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

public class DetailSortProcessor implements PageProcessor{
    Site site=Site.me().setRetryTimes(3).setSleepTime(1000);
    static String reurl;
    static int recount=0;
    @Override
    public void process(Page page) {

        Html html=page.getHtml();
        if (html.toString().contains("<title>京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！</title>")){
            reurl=page.getRequest().getUrl();
            DetailSortProcessorRun(reurl);
        }
        List<String> urlList=html.xpath("//div[@id=\"J_searchWrap\"]/div[@id=\"J_container\"]/div[@id=\"J_main\"]" +
                "/div[@class=\"m-list\"]/div[@class=\"ml-wrap\"]/div[@id=\"plist\"]/ul/li/div/div[@class=\"p-name\"" +
                "]/a/@href").all();
        List<String> name=html.xpath("//div[@id=\"J_searchWrap\"]/div[@id=\"J_container\"]/div[@id=\"J_main\"]" +
                "/div[@class=\"m-list\"]/div[@class=\"ml-wrap\"]/div[@id=\"plist\"]/ul/li/div/div[@class=\"p-name\"" +
                "]/a/em/text()").all();
        if (!urlList.isEmpty()){
            page.addTargetRequests(urlList);
            int i=0;
            for (String url:urlList){
                page.putField(url,name.get(i++));
            }
        }else {
            urlList = html.xpath("//div[@class=\"w\"]/div[@class=\"detail\"]//div[@id=\"detail\"]/div[@class=\"tab-con\"]/div/div[@class=\"p-parameter\"]/ul/li").all();
            if (!urlList.isEmpty()) {
                page.addTargetRequests(urlList);
                int i = 0;
                for (String url : urlList) {
                    page.putField(i + "+++:", url);
                }

            }

        }
    }

    @Override
    public Site getSite() {
        return site;
    }
    public void DetailSortProcessorRun(String reurl){
        recount++;
        if (recount%100==0){
            System.out.println("+++++++++++++++++++++"+recount);
        }
        Spider.create(new DetailSortProcessor()).addUrl(reurl).thread(5).run();
    }
    public static void main(String args[]){
        Spider.create(new DetailSortProcessor()).addUrl("https://list.jd.com/list.html?cat=737,1277,1295").thread(5).run();

    }
}
