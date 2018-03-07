package com.ll.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateFormatutil {
    public static String CurrentDateFormatUtil(){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String formatdate=dateFormat.format(date);

        return formatdate;
    }
}
