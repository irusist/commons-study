package com.irusist.commons.math;

import org.apache.commons.lang.math.DoubleRange;
import org.apache.commons.lang.math.Range;

/**
 * Range safeSpeed = new DoubleRange(0.0, 65.0);
 * safeSpeed.containsDouble(Double)     safeSpeed是否包含Double
 * safeSpeed.containsRange(Range)       safeSpeed是否包含Range的范围（包含Range的最小值和最大值)
 *
 * @author zhulixin
 */
public class UseNumberRanges {

    public static void main(String[] args) {
        Range safeSpeed = new DoubleRange(0.0, 65.0);
        double currentSpeed = 65.1;
        if (!safeSpeed.containsDouble(currentSpeed)) {
            System.out.println("Warning, current speed is unsafe.");
        }
    }
}
