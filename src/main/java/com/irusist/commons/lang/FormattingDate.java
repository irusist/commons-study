package com.irusist.commons.lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * DateFormatUtils:
 * FaseDateFormat:
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午5:01
 */
public class FormattingDate {

    public static void main(String[] args) {
        Date now = new Date();
        String isoDT = DateFormatUtils.SMTP_DATETIME_FORMAT.format(now);

        System.out.println("It is currently: " + isoDT);

        FastDateFormat formatter = FastDateFormat.getInstance("yyyy-mm", TimeZone.getDefault(), Locale.getDefault());
        String output = formatter.format(new Date());
        System.out.println(output);
    }
}
