package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.chomp(string),去掉string末尾的一个\r,\n,\r\n
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午6:15
 */
public class ChompString {

    public static void main(String[] args) {
        String input = "Hello\r\n";
        String chomped = StringUtils.chomp(input);
        String input2 = "Another test\r\n";
        String chomped2 = StringUtils.chomp(input2);
        System.out.println(chomped);
        System.out.println(chomped2);
    }
}
