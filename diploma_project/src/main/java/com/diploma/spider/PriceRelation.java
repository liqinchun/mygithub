package com.diploma.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class PriceRelation implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {

        Html html=page.getHtml();
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new PriceRelation()).addUrl("https://detail.tmall.com/item.htm?spm=a220m.1000858.1000725.1.527c3" +
                "aadJBOHwL&id=530490839496&skuId=3160780093004&areaId=510100&standard=1&user_id=470168984&cat_id=509" +
                "18004&is_b=1&rn=e361bd221cc6732fb432c4849f97ceda").thread(5).run();

    }
}
