package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ArrayUtils: array的clone和reverse
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午4:11
 */
public class CloneReverseArray {

    public static void main(String[] args) {
        long[] array = {1, 3, 2, 3, 5, 6};
//        int[] i = null;
//        i.clone();
        // 如果array是null，直接用array.clone()会跑出NullPointerException()
        long[] reversed = ArrayUtils.clone(array);
        // Collections.reverse(List)只作用于List，不能操作数组
        ArrayUtils.reverse(reversed);

        System.out.println("Original: " + ArrayUtils.toString(array));
        System.out.println("Reversed: " + ArrayUtils.toString(reversed));

        Long[] array2 = new Long[]{new Long(3), new Long(56), new Long(233)};
        Long[] reversed2 = ArrayUtils.clone(array2);
        ArrayUtils.reverse(reversed2);
        System.out.println("Original: " + ArrayUtils.toString(array2));
        System.out.println("Reversed: " + ArrayUtils.toString(reversed2));
    }

}
