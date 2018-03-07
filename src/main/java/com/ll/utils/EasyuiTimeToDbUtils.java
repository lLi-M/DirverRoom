package com.ll.utils;

public class EasyuiTimeToDbUtils {

    //处理12/19/2017这类数据TO 2017-12-19
    public static String convertTime(String EasyuiTime) {

        String[] strings = EasyuiTime.split("/");

        if(Integer.parseInt(strings[0])<10){
            strings[0]="0"+strings[0];
        }
        if(Integer.parseInt(strings[1])<10){
            strings[1]="0"+strings[1];
        }
        String DBTime=strings[2]+"-"+strings[0]+"-"+strings[1];
        return  DBTime;
    }
}
