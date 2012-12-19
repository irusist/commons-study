package com.irusist.commons.math;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;

/**
 * double max = NumberUtils.max(array);
 * 如果array为null或者是empty，则抛出IllegalArgumentException
 *
 *
 * @author zhulixin
 */
public class FindMaxMinInArray {

    public static void main(String[] args) {
        double[] array = {0.2, 0.4, 0.5, -3.0, 4.223, 4.226};

        double max = NumberUtils.max(array);
        double min = NumberUtils.min(array);
        System.out.println(max);    // 4.226
        System.out.println(min);    // -3.0

        Max maxinum = new Max();
        Min mininum = new Min();
        double max2 = maxinum.evaluate(array, 0, array.length);
        double min2 = mininum.evaluate(array, 0, array.length);
        System.out.println(max2);    // 4.226
        System.out.println(min2);    // -3.0

    }
}
