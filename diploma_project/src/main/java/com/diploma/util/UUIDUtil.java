package com.diploma.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
    //生成带前缀的UUID
    public static String getUUID(String prefix){
        return (prefix+"_"+getUUID()).toUpperCase();
    }
}
