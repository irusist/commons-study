package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ArrayUtils:
 * contains,indexOf,lastIndexOf
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午4:37
 */
public class ArrayContainsIndexOf {

    public static void main(String[] args) {
        String[] stringArray = {"Red", "Orange", "Blue", "Brown", "Red"};

        boolean containsBlue = ArrayUtils.contains(stringArray, "Blue");
        int indexOfRed = ArrayUtils.indexOf(stringArray, "Red");
        int lastIndexOfRed = ArrayUtils.lastIndexOf(stringArray, "Red");

        System.out.println("Array contains 'Blue'? " + containsBlue);
        System.out.println("Index of 'Red': " + indexOfRed);
        System.out.println("Last Index of 'Red' :" + lastIndexOfRed);
    }
}
