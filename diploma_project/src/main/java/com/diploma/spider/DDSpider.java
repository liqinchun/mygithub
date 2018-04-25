package com.diploma.spider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.diploma.mysql.dao.CatagoryResitory;
import com.diploma.mysql.model.CatagoryVo;
import com.diploma.mysql.model.Category;
import com.diploma.mysql.model.Product;
import com.diploma.pipeline.DDPipeline;
import com.diploma.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;


public class DDSpider implements PageProcessor{

//    @Autowired
//    private ProductResitory productResitory;
    @Autowired
    private CatagoryResitory catagoryResitory;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    static int i=1;
    public void process(Page page) {

        Html html=page.getHtml();
        List<String> targetUrl;
        Selectable url=page.getUrl();

        //爬取当当首页
        targetUrl=html.xpath("//div[@id=\"hd\"]/div[@class=\"nav_top\"]/ul/li[@class=\"all\"]/a/@href").all();
        if (!targetUrl.isEmpty()){
            page.addTargetRequests(targetUrl);
        }else{
            //爬取全部分类页面
            targetUrl=html.xpath("//div[@id=\"bd\"]/div/div/div[@class=\"" +
                        "classify_content\"]/div[@class=\"classify_con\"]/div/div/div[@class=\"classify_kind\"]/div[@class=\"classify_kind_name\"]/a/@href").all();
            List<String> catagoryNames=html.xpath("//div[@id=\"bd\"]/div/div/div[@class=\"" +
                    "classify_content\"]/div[@class=\"classify_con\"]/div/div/div[@class=\"classify_kind\"]/div[@class=\"classify_kind_name\"]/a/text()").all();


            if (!targetUrl.isEmpty()) {
                page.putField("catagory", getCatagorys(targetUrl, catagoryNames));
                page.addTargetRequests(targetUrl);
            }
//            }else {
//                //获取商品详细页面
//                targetUrl=html.xpath("//div[@id=\"bd\"]/div[@class=\"con\"]/div[@id=\"12808\"]" +
//                        "/div[@id=\"12810\"]/div/div[@class=\"con shoplist\"]/div[@id=\"search_nature_rg\"]/ul/li/a/@href").all();
//                if (!targetUrl.isEmpty()) {
//                    page.addTargetRequests(targetUrl);
//
//                }else {
//                    //价格
//                    List<String>price=html.xpath("//div[@class=\"product_wrapper\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
//                            "/div[@class=\"sale_box clearfix\"]/div[@id=\"product_info\"]/div[@class=\"price_info clearfix\"]/div[@id=\"pc-price\"]" +
//                            "/div[@class=\"price_d\"]/p[@id=\"dd-price\" ]/text()").all();
//
//                    //title
//                    List<String> title=html.xpath("//div").all();
//                    System.out.println("价格"+(i++)+":"+price+"+++++++++++++++++++++++++++++++++++++++++++++++");
//                }
//            }
        }

//        switch(i)
//        {
//            case 1:
//                //当当网主页下面爬去全部分类页面链接
//                targetUrl=html.xpath("//div[@id=\"hd\"]/div[@class=\"nav_top\"]/ul/li[@class=\"all\"]/a/@href").all();
//                if (!targetUrl.isEmpty()){
//                    page.addTargetRequests(targetUrl);
//                }
//                i++;
//                break;
//            case 2:
//                targetUrl=html.xpath("//div[@id=\"bd\"]/div/div/div[@class=\"" +
//                        "classify_content\"]/div[@class=\"classify_con\"]/div/div/div[@class=\"classify_kind\"]/div[@class=\"classify_kind_name\"]/a/@href").all();
//                if (!targetUrl.isEmpty()){
//                    page.addTargetRequests(targetUrl);
//                }
//                i++;
//                break;
//            case 3:
//                targetUrl=html.xpath("//div[@id=\"bd\"]/div[@class=\"con\"]/div[@id=\"12808\"]" +
//                        "/div[@id=\"12810\"]/div/div[@class=\"con shoplist\"]/div[@id=\"search_nature_rg\"]/ul/li/a/@href").all();
//                if (!targetUrl.isEmpty()){
//                    page.addTargetRequests(targetUrl);
//                }
//                i++;
//                break;
//            case 4:
//                //封装商品具体信息
//
//                List<Product> products=new ArrayList<Product>();
//                Product product=new Product();
////                product.setProductPrice(Double.parseDouble(html.xpath("").toString()));
//                String price=html.xpath("//*/body/div[@class=\"product_wrapper product_fb\"]/div[@class=\"product_main clearfix\"]/div[@class=\"show_info\"]" +
//                        "/div[@class=\"sale_box clearfix\"]/div[@class=\"sale_box_left\"]/div[@class=\"price_info clearfix\"]/div[@class=\"price_pc\"]" +
//                        "/div[@class=\"price_d\"]/p[@id=\"dd-price\"]/text()").all().toString();
//
//                product.setProductId("");
//                product.setProducrName("");
//                product.setProductImgUrl("");
//                product.setProductUrl(page.getUrl().toString());
//                targetUrl=html.xpath("//*/body/script/@var[@name=\"prodSpuInfo\"]").all();
//                System.out.println("default"+i);
//               // productResitory.save(products);
//            default:
//                System.out.println("default"+i);
//                targetUrl=html.xpath("//*").all();
//                i=1;
//                break;
//        }

    }

    public Site getSite() {
        return site;
    }

    public static void main(String args[]){
        us.codecraft.webmagic.Spider.create(new DDSpider()).addPipeline(new DDPipeline()).addUrl("http://www.dangdang.com/")
                .thread(5).run();
    }


    public List<Category> getCatagorys(List<String> targetUrl,List<String> catagoryName){
        //封装爬取到的所有种类
        List<Category> catagoryVos=new ArrayList<Category>();
        Category category;
        int i=0;
        for (String catagoryUrl:targetUrl){
            category=new Category();
            category.setId(UUIDUtil.getUUID("CATEGORY"));
            category.setName(catagoryName.get(i++));
            category.setUrl(catagoryUrl);
            catagoryVos.add(category);
        }
        return catagoryVos;
    }

}
