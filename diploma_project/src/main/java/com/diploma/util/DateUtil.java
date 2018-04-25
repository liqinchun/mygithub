package com.diploma.util;


import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

public class DateUtil {
    public Date getSqlDate(){
        java.util.Date utilDate = new java.util.Date(); //获取当前时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime());
        System.out.println(simpleDateFormat.format(sqlDate));
        return sqlDate;
    }

    public java.util.Date getUtilDate(){
        // sql.date转换成util.date
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        return utilDate;
    }

    @Test
    public void fun01(){
        System.out.println(getSqlDate());
        System.out.println(getUtilDate());
    }
}
