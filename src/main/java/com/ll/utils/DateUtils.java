package com.ll.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ll.VO.DateVo;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {
    static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String plusDate(int number) {
        long currentMillis = System.currentTimeMillis();
        DateTime date = new DateTime(currentMillis);
        DateTime dateone = date.plusDays(number);
        logger.debug("====>当前时间为"+dateone.toString("yyyy-MM-dd"));
        return dateone.toString("yyyy-MM-dd");
    }

    public static String getDateToSS() {
        long currentMillis = System.currentTimeMillis();
        DateTime date = new DateTime(currentMillis);

        String datess = date.toString("yyyy-MM-dd HH:mm:ss");
        logger.debug("===>当前时间为"+datess);

        return datess;
    }

    public static String[] plusDateandWeek(int number) {
        long currentMillis = System.currentTimeMillis();
        DateTime date = new DateTime(currentMillis);
        logger.debug("=====>当前时间为"+date.toString("yyyy-MM-dd"));

        DateTime dateone = date.plusDays(number);
        String[] dateandweek = new String[2];
        dateandweek[0] = dateone.toString("yyyy-MM-dd");
        dateandweek[1] = dateone.dayOfWeek().getAsText();
        return dateandweek;
    }

    public static List<DateVo> getDays(int days, int daysub) {
        int day = days;
        List<DateVo> dayStrings = new ArrayList<DateVo>(5);

        while (day >= daysub) {
            DateVo vo = new DateVo();
            String date[] = plusDateandWeek(day);
            vo.setDate(date[0]);
            vo.setWeek(date[1]);
            dayStrings.add(vo);
            --day;
        }

        return dayStrings;
    }

    public static Date getDate(String day) {
        String[] days = day.trim().split("-");
        DateTime dateTime = new DateTime(Integer.parseInt(days[0]), Integer.parseInt(days[1]),
                Integer.parseInt(days[2]), 0, 0, 0, 0);
        Date date = new Date(dateTime.getMillis());
        return date;
    }

    public static int getDays(String day) {
        String[] days = day.trim().split("-");
        DateTime dateTime = new DateTime(Integer.parseInt(days[0]), Integer.parseInt(days[1]),
                Integer.parseInt(days[2]), 0, 0, 0, 0);
        logger.debug("进入getDays,计算日期差");
        logger.debug("=====>当前时间为"+dateTime.toString("yyyy-MM-dd"));

        long currentMillis = System.currentTimeMillis();

        DateTime datenow = new DateTime(currentMillis);
        logger.debug("=====>当前时间为"+datenow.toString("yyyy-MM-dd"));

        int between = Days.daysBetween(datenow.withTimeAtStartOfDay(), dateTime.withTimeAtStartOfDay())
                .getDays();
        return between;
    }

    public static int getDay(String day) {
        String[] days = day.trim().split("-");
        DateTime dateTime = new DateTime(Integer.parseInt(days[0]), Integer.parseInt(days[1]),
                Integer.parseInt(days[2]), 0, 0, 0, 0);        long currentMillis = System.currentTimeMillis();

        DateTime datenow = new DateTime(currentMillis);
        logger.debug("=====>当前时间为"+datenow.toString("yyyy-MM-dd"));

        int between = Days.daysBetween(dateTime.withTimeAtStartOfDay(), datenow.withTimeAtStartOfDay())
                .getDays();
        logger.debug("=====>当前时间查为"+between);

        return between;
    }

    public static List<String> getDaysCanvel(Integer days) {
        int day = days;
        List<String> dayStrings = new ArrayList<String>();

        while (day > 0) {
            String date = plusDate(day);
            dayStrings.add(date);
            --day;
        }

        return dayStrings;
    }
}

