package com.ll.VO;



import com.sun.corba.se.impl.orb.ParserTable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ll.service.*;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class Test extends AbstractRoutingDataSource {



    @org.junit.Test
    public void test(){
        String s="12/19/2017";
        String[] strings=s.split("/");
        String app=strings[2]+"-"+strings[0]+"-"+strings[1];
        System.out.println(app);
    }
@org.junit.Test
    public void test1(){
     Date date=new Date();
     DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
     String formatdate=dateFormat.format(date);
        System.out.println(formatdate);
    }
    @org.junit.Test
    public void zhaunyi(){

    }
    @org.junit.Test
    public void  common(){
        String time="1,2,3,4,5,6,8,9,10";
        String[] times=time.split(",");

    }
    @org.junit.Test
    public void test3(){
        String s="06";
        String[] hour =s.split(",");
        List list=Arrays.asList(hour);
        System.out.println(hour);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
