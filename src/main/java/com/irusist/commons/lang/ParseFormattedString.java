package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;

/**
 * StringUtils.substringBetween(string, open, close)取string中在open和close之间的字符
 * StringUtils.substringAfter(string, separator)在第一次出现separator之后的字符
 * StringUtils.substringBefore(string, separator)在第一次出现separator之前的字符
 * StringUtils.substringAfterLast(string, separator)在最后一次出现separator之后的字符
 * StringUtils.substringBeforeLast(string, separator)在最后一次出现separator之前的字符
 * string.trim()方法不能处理null的值，StringUtils.trim(string)可以处理null。
 * string.substring()不能处理null 的值，StringUtils.substring()可以处理null。
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午4:10
 */
public class ParseFormattedString {

    public static void main(String[] args) throws Exception{
        String formatted = "25 * (30,40) [50,60] | 30 | 70 * t ";

        PrintStream out = System.out;
        out.println("N0: " + StringUtils.substringBefore(formatted, "*"));
        out.println(", N1: " + StringUtils.substringBetween(formatted, "(", ","));
        out.println(", N2: " + StringUtils.substringBetween(formatted, ",", ")"));
        out.println(", N3: " + StringUtils.substringBetween(formatted, "[", ","));
        out.println(", N4: " + StringUtils.substringBetween(formatted, ",", "]"));
        out.println(", N5: " + StringUtils.substringAfter(formatted, "|"));
    }
}