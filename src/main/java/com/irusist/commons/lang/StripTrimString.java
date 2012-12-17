package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.trim(string),去掉string的空白字符，控制字符（ASCII码从0到31），特殊字符
 * StringUtils.strip(string,stripChars)去掉首尾的指定字符stripChars
 * StringUtils.trimToNull(string),先trim，如果是null则返回null。
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午4:54
 */
public class StripTrimString {

    public static void main(String[] args) {
        String test1 = " \\a\r Testing 1 2 3";
        String test2 = "\r\n";

        String trimTest1 = StringUtils.trim(test1);
        String trimTest2 = StringUtils.trim(test2);

        System.out.println(trimTest1);
        System.out.println(trimTest2);

        String original = "---------***SHAZAM-----------****-------------";
        String stripped = StringUtils.strip(original, "-*");
        System.out.println("Stripped: " + stripped);
    }
}
