package com.diploma.spider;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SCatalogSpider implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    //用来存储cookie信息
    private Set<Cookie> cookies;
    @Override
    public void process(Page page) {
        Html html=page.getHtml();

        String url=page.getUrl().toString();
    }

    //使用 selenium 来模拟用户的登录获取cookie信息
    public void login()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://login.jiayuan.com/?channel=200&position=204&pre_url=http%3A%2F%2Fsearch.jiayuan.com%2Fv2%2F");

        driver.findElement(By.id("login_email")).clear();

        //在******中填你的用户名
        driver.findElement(By.id("login_email")).sendKeys("18428325734");

        driver.findElement(By.id("login_password")).clear();
        //在*******填你密码
        driver.findElement(By.id("login_password")).sendKeys("l18428325734");

        //模拟点击登录按钮
        driver.findElement(By.id("login_btn")).click();

        //获取cookie信息
        cookies = driver.manage().getCookies();
        driver.close();
    }

    @Override
    public Site getSite() {
//        //将获取到的cookie信息添加到webmagic中
//        for (Cookie cookie : cookies) {
//            site.addCookie(cookie.getName().toString(),cookie.getValue().toString());
//        }
//
//        return site.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1");
        return site;
    }

    public static void main(String args[]){
        Spider.create(new SCatalogSpider()).addUrl("https://list.tmall.com/search_product.htm?spm=a222t.7794920.fsnav.1.3dac667cy" +
                "Fmqoq&cat=50918004&acm=lb-zebra-24139-328537.1003.4.455785&scm=1003.4.lb-zebra-24139-328537.OTHER_14458832193540_455785").thread(5).run();
    }
}
