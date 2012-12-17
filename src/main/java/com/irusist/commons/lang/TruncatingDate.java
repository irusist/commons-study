package com.irusist.commons.lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtils.truncate();
 * 截取日期
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午6:05
 */
public class TruncatingDate {

    public static void main(String[] args) {
        FastDateFormat dtFormat = DateFormatUtils.ISO_DATETIME_FORMAT;

        Date now = new Date();
        Date truncatedMonth = DateUtils.truncate(now, Calendar.MONTH);
        Date truncatedHour = DateUtils.truncate(now, Calendar.HOUR);

        System.out.println("Now: " + dtFormat.format(now));
        System.out.println("Truncated Month: " + dtFormat.format(truncatedMonth));
        System.out.println("Truncated Hour: " + dtFormat.format(truncatedHour));
    }
}
