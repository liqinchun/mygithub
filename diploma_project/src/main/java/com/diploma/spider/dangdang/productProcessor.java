package com.diploma.spider.dangdang;
import com.diploma.mysql.dao.ProductDetailResitory;
import com.diploma.mysql.model.HistoryPrice;
import com.diploma.mysql.model.ProductDetail;
import com.diploma.service.CatagoryService;
import com.diploma.spider.MysqlPipeline;
import com.diploma.util.MyJedisPoolUtil;
import com.diploma.util.UUIDUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class productProcessor implements PageProcessor{
    Site site=Site.me().setSleepTime(1000).setRetryTimes(3);
    @Override
    public void process(Page page) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductDetailResitory productDetailResitory=(ProductDetailResitory)applicationContext.getBean("productDetailResitory");
        CatagoryService catagoryService=(CatagoryService) applicationContext.getBean("catagoryServiceImpl");
        Html html=page.getHtml();
        String url=page.getRequest().getUrl();
        String productId="";



        if (false){
            price(html,productId,page);
        }else{
            saveProduct(html,page,url);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        Spider.create(new productProcessor()).addPipeline(new MysqlPipeline()).addUrl("http://product.dangdang.com/25230126.html").thread(5).run();
    }

    //url已经爬取过只爬取历史价格信息
    public void price(Html html,String productId,Page page){
        List<String> price=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"price_info clearfix\"]/div[@id=\"pc-price\"]" +
                "/div[@class=\"price_d\"]/p[@id=\"dd-price\"]/text()").all();
        HistoryPrice historyPrice=new HistoryPrice();
        historyPrice.setProductId(productId);
        historyPrice.setPriceId(UUIDUtil.getUUID());
        historyPrice.setPrice(price.get(0));
        historyPrice.setCrateTime(new Date());
        page.putField("historyPrice",historyPrice);
    }
    //发现未爬取过的url  保存全部商品信息
    public void saveProduct(Html html,Page page,String url){
        List<String> price=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"price_info clearfix\"]/div[@id=\"pc-price\"]" +
                "/div[@class=\"price_d\"]/p[@id=\"dd-price\"]/text()").all();

        List<String> picUrl=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"pic_info\"]" +
                "/div[@id=\"largePicDiv\"]/a/img/@src").all();

        List<String> details=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_content clearfix\"]/div[@id=\"right-content\"]" +
                "/div[@id=\"product_tab\"]/div[@id=\"detail_all\"]/div[@id=\"detail_describe\"]/ul/li/text()").all();
        String detailString=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_content clearfix\"]/div[@id=\"right-content\"]" +
                "/div[@id=\"product_tab\"]/div[@id=\"detail_all\"]/div[@id=\"detail_describe\"]/ul/li/text()").all().toString();
        List<String> catalog=html.xpath("//div[@class=\"product_wrapper\"]/div[@id=\"breadcrumb\"]/a").all();
        List<String> catalog1=html.xpath("//div[@class=\"product_wrapper\"]/div[@id=\"breadcrumb\"]/a/text()").all();
        List<String> title=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"name_info\"]/h1/text()").all();
        List<String> description=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
                "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"name_info\"]/h2/span[@class=\"head_title_name\"]/text()").all();


        //封装 product信息
        ProductDetail productDetail=new ProductDetail();
        productDetail.setProductId(UUIDUtil.getUUID());
        productDetail.setCreateTime(new Date());
        for (String detail:details){
            if (detail.contains("ISBN")){
                productDetail.setProductType(detail);
            }
        }
        productDetail.setProductName(title.get(0));
        productDetail.setDescripton(description.get(0));
        productDetail.setOrignPlace(price.get(0));
//        productDetail.setCatagoryId(catalog1.get(0));
        productDetail.setImageurl(picUrl.get(0));
        productDetail.setUrl(url);

        page.putField("productDetail",productDetail);
        page.putField("catagory",catalog1);
    }
}
