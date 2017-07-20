package cn.river.utils;

import java.util.Calendar;

/**
 * Created by cankao on 16/8/18.
 */
public class UtilDate {
    public static String stamp() {
        return ""+System.currentTimeMillis();
    }
    public static String yyyymmdd() {
        int year;
        int month;
        int day;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return ""+year +"-"+ (month < 10 ? "0" + month : month) +"-"+ (day < 10 ? "0" + day : day);
    }

    public static String yyyymm() {
        int year;
        int month;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        return ""+year +"-"+ (month < 10 ? "0" + month : month);
    }
}
