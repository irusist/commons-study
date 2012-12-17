package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.isBlank(),
 * StringUtils.isNotBlank(),
 * StringUtils.isEmpty(),
 * StringUtils.isNotEmpty(),
 * StringUtils.trimToNull()
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午3:01
 */
public class EmptyStringCheck {

    public static void main(String[] args) {
        String test = "";
        String test2 = "\n\n\t";
        String test3 = null;
        String test4 = "Test";

        // StringUtils.isBlank(String) 当String为null，空字符串，或者是空白字符（\n,\t）时返回true
        System.out.println("test blank? " + StringUtils.isBlank(test));
        System.out.println("test2 blank? " + StringUtils.isBlank(test2));
        System.out.println("test3 blank? " + StringUtils.isBlank(test3) );
        System.out.println("test4 blank? " + StringUtils.isBlank(test4));

        String str = "\t";
        String str2 = "Test";
        String str3 = null;

        // 去掉string左右的空白字符，如果是null或者空字符串，则返回null
        System.out.println("str trimToNull: " + StringUtils.trimToNull(str));
        System.out.println("str2 trimToNull: " + StringUtils.trimToNull(str2));
        System.out.println("str3 trimToNull: " + StringUtils.trimToNull(str3));
        System.out.println("\t".trim());
    }
}
