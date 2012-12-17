package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayUtils: 打印数组，List
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午3:54
 */
public class PrintArray {

    public static void main(String[] args) {
        int[] intArray = new int[]{2, 3, 4, 5, 6};
        int[][] multiDimension = new int[][]{{1, 2, 3}, {2, 3}, {5, 6, 7}};
        System.out.println("inArray: " + ArrayUtils.toString(intArray));
        System.out.println("multiDimension: " + ArrayUtils.toString(multiDimension));

        // 这里只是当strigs为null时才打印Unknown，如何在内部有null时单个打印null？
        String[] strings = new String[]{"Blue", "Green", null, "Yellow"};
        System.out.println("Strings: " + ArrayUtils.toString(strings, "Unknown"));

        List<String> list = new ArrayList<String>();
        list.add("Foo");
        list.add("Blah");
        System.out.println(ArrayUtils.toString(list));
        System.out.println(ArrayUtils.toString(list.toArray()));
    }
}
