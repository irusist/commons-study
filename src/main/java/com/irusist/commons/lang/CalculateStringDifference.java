package com.irusist.commons.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils.getLevenshteinDistance(string,string)表示从一个字符串
 * 通过增加，删除，变更到另一个字符串需要多次变化
 * StringUtils.difference(string1,string2)表示string2对string1比较不同地方开始，
 * string2后面的内容
 * StringUtils.indexOfDifference("Word", "World")表示不同地点的索引。
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午4:30
 */
public class CalculateStringDifference {

    public static void main(String[] args) {
        int dist = StringUtils.getLevenshteinDistance("Steve", "Stereo");
        String diff = StringUtils.difference("Word", "World");
        int index = StringUtils.indexOfDifference("Word", "World");

        // print 2
        System.out.println("Edit Distance: " + dist);
        // print ld
        System.out.println("Difference: " + diff);
        // print 3
        System.out.println("Diff Index: " + index);
    }
}
