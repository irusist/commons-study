package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * WordUtils.wrap(string,wrapLength,newLineString,wrapLongWords)
 * 会将在warpLength处进行加上newLineString进行封装，如果加上longWords(url)
 * 超过了wrapLength，则单独将url分隔开，wrapLongwords代表是否对url进行分隔。
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午3:18
 */
public class WrapWords {

    public static void main(String[] args) {
        String message = "One Two Three Four Five";
        String wrappedString = WordUtils.wrap(message, 20, "\n", true);
        System.out.println("Wrapped Message:\n\n" + wrappedString);

        String words = "Four score and seven years ago, our fathers " +
                "brought forth upon this continent a new nation: conceived " +
                "in liberty, and dedicated to the proposition that all men " +
                "are created equal. http://www.oreilly.com/Gettysburgdddgrtgrtgd ";
        System.out.println(WordUtils.wrap(words, 40, "</br>", false));

    }
}
