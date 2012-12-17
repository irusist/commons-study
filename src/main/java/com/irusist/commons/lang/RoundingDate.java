package com.irusist.commons.lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtils.round()
 * 将小时，日期，年进行四舍五入。
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午5:37
 */
public class RoundingDate {

    public static void main(String[] args) {
        FastDateFormat dfFormat = DateFormatUtils.ISO_DATETIME_FORMAT;

        Date now = new Date();
        Date nearestHour = DateUtils.round(now, Calendar.HOUR);
        Date nearestDay = DateUtils.round(now, Calendar.DAY_OF_MONTH);
        Date nearestYear = DateUtils.round(now, Calendar.YEAR);

        DateUtils.round(now, Calendar.MILLISECOND);
        DateUtils.round(now, Calendar.SECOND);
        DateUtils.round(now, Calendar.MINUTE);
        DateUtils.round(now, Calendar.HOUR_OF_DAY);
        DateUtils.round(now, Calendar.HOUR);
        DateUtils.round(now, Calendar.DATE);
        DateUtils.round(now, Calendar.DAY_OF_MONTH);
        DateUtils.round(now, Calendar.AM_PM);
        DateUtils.round(now, Calendar.MONTH);
        DateUtils.round(now, DateUtils.SEMI_MONTH);
        DateUtils.round(now, Calendar.YEAR);
        DateUtils.round(now, Calendar.ERA);


        System.out.println("Now: " + dfFormat.format(now));
        System.out.println("Nearest Hour : " + dfFormat.format(nearestHour));
        System.out.println("Nearest Day: " + dfFormat.format(nearestDay));
        System.out.println("Nearest Year : " + dfFormat.format(nearestYear));

        // DateUtils.SEMI_MONTH：以一个月的中间时间来判断
        // 如果指定日期离月初(9th,00:00:00之前的，不包括)近，则返回Mon Mar 01 00:00:00 CST 2004
        // 如果指定日期离月中(9th,00:00:00之后的，24th,00:00:00之间)近，则返回Tue Mar 16 00:00:00 CST 2004
        // 如果指定日期在月末（24th,0:00:00之后的，包括）,返回Thu Apr 01 00:00:00 CST 2004
        Calendar cal = Calendar.getInstance();
        cal.set(2004, Calendar.MARCH, 24, 00, 00, 00);
        System.out.println(DateUtils.round(cal.getTime(), DateUtils.SEMI_MONTH));
    }
}
