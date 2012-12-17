package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * StringUtils.substringBetween(String str, String open, String close)
 * 获取在str当中，在open和close之间的数据。
 * StringUtils.substringBetween(String str, String open)
 * 相当于StringUtils.substringBetween(String str, String open, String open)
 * ArrayList.toArray()方法最好不要用，因为他返回的是Object[],可以用
 * ArrayList.toArray(T[])
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午4:27
 */
public class FindNestedString {

    public static void main(String[] args) {
        String htmlContent = "<html>\n" +
                "  <head>\n" +
                "    <title>Test Page</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <p>This is a TEST!</p>\n" +
                "  </body>\n" +
                "</html>";
        String title = StringUtils.substringBetween(htmlContent, "<title>", "</title>");
        System.out.println("Title: " + title);

        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("5");
//        String[] a = (String[])list.toArray();
        String[] a = list.toArray(new String[3]);
    }
}
