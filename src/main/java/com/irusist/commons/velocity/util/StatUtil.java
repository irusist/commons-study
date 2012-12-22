package com.irusist.commons.velocity.util;

/**
 * description
 *
 * @author zhulixin
 */
public class StatUtil {

    public int average(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }

        return sum / array.length;
    }

    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
