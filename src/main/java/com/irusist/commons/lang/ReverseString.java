package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.reverse(string),每个字符都逆序
 * StringUtils.reverseDelimited(string,separatorChar)，以separatorChar来分隔逆序。
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午3:03
 */
public class ReverseString {

    public static void main(String[] args) {
        String original = "In time, I grew tried of his babbling nonsense.";
        String reverse = StringUtils.reverse(original);
        String originalGenes = "AACGTCCCTTGGTTTCCCAAAGTTTCCCTTTGAAATATATGCCCGCG";
        String reverseGenes = StringUtils.reverse(originalGenes);

        System.out.println("Original: " + original);
        System.out.println("Reverse: " + reverse);
        System.out.println("\n\nOriginal: " + originalGenes);
        System.out.println("Reverse: " + reverseGenes);

        String sentence = "I am Susan.";
        // 用StringUtils.removeEnd(string, separator)代替
        String reversed = StringUtils.chomp(sentence, ".");
        reversed = StringUtils.reverseDelimited(reversed, ' ');
        System.out.println(reversed + ".");
    }
}
