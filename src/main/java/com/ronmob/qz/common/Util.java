package com.ronmob.qz.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建时间：9/22/17
 * 创建人：sunwuyang
 */
public class Util {
    public static Date getDateFromString(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";

        if (dateString.length() > 10)
            pattern = "yyyy-MM-dd hh:mm:ss";

        return getDateFromString(dateString, pattern);
    }


    public static Date getDateFromString(String dateString, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateString);
        return date;
    }
}
