package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.abbreviate(string,length) 不够length的以...表示
 * StringUtils.abbreviate(String,offset,length),在offset之前的用...表示，不够length的用...表示
 * User: zhulixin
 * Date: 12-11-28
 * Time: 下午3:25
 */
public class AbbreviateString {

    public static void main(String[] args) {
        String test = "Who do you think you are?";
        String test2 = "Test";

        System.out.println(StringUtils.abbreviate(test, 20));
        System.out.println(StringUtils.abbreviate(test2, 4));


        String message = "There was a palpable sense that the rest of the world " +

                "might, one day, cease to exist. In the midst of the " +

                "confusion - the absence of firm ground - something would " +

                "fail to recover. The whole city is still, in a way, " +

                "holding it's breath, hoping the the worst has come and " +

                "gone.";
        int index = message.indexOf("ground");
        System.out.println(index);
        int offset = index - 20;
        int width =  message.length() - index;
        String context = StringUtils.abbreviate(message, offset, 20);
        System.out.println("The word 'ground' in context: " + context);
    }

}
