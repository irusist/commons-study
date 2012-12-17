package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.replaceChars(string,searchChars,replaceChars)
 * 将searchChars替换成replaceChars
 * StringUtils.isNumeric(string)判断string是否都是数字
 * StringUtils.isAlpha(string)判断string是否都是字母
 * StringUtils.isAlphaSpace(string)判断string是否都是字母和空格
 * StringUtils.isAlphanumeric(string)。。。等等组合
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午3:34
 */
public class TestStringContent {

    public static void main(String[] args) {
        String state = "Virginia";

        System.out.println("Is state number? " + StringUtils.isNumeric(state));
        System.out.println("Is state alpha? " + StringUtils.isAlpha(state));
        System.out.println("Is state alphanumeric? " + StringUtils.isAlphanumeric(state));
        System.out.println("is state alphaspace? " + StringUtils.isAlphaSpace(state));

        String name1 = "Tim O'Reilly";
        String name2 = "Mr. Mason-Dixon!";
        String punctuation = ".-'";
        String name1Temp = StringUtils.replaceChars(name1, punctuation, "");
        String name2Temp = StringUtils.replaceChars(name2, punctuation, "");

        boolean t1val = StringUtils.isAlphaSpace(name1Temp);
        boolean t2val = StringUtils.isAlphaSpace(name2Temp);
        System.out.println(t1val);
        System.out.println(t2val);
    }
}




