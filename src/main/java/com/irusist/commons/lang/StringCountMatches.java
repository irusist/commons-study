package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.countMatches(string,sub)返回sub在string出现的次数
 * 如果从文件中检索某个字符出现的次数不要全部放入内存，可以建立index和search documents
 * 利用lucence
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午4:03
 */
public class StringCountMatches {

    public static void main(String[] args) {
        String message = "a test adas test fsifjotestjoijfosdtestoijfstestfsdf";
        int count = StringUtils.countMatches(message, "test");
        System.out.println(count);
    }
}
