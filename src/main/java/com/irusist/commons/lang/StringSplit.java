package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.split(string,separatorChars,max),
 * separatorChars对每个字符都作为分隔符
 * 如果分割的数组长度大于max，则第max-1个元素会返回剩余的所有字符，包括分隔符。
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午4:11
 */
public class StringSplit {

    public static void main(String[] args) {
        String input = "Frantically oblong";
        String input2 = "Phararcybasketballfuncky";

        String[] array1 = StringUtils.split(input, " ", 2);
        String[] array2 = StringUtils.split(input2, "ac",4);

        System.out.println(ArrayUtils.toString(array1));
        System.out.println(ArrayUtils.toString(array2));
    }
}
