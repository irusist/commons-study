package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ArrayUtils:
 * 将object的数组于primitive的数组进行转化
 * object数组可以有null，而primitive数组就不能有。
 * Arrays.asList(),list.toArray()
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午4:28
 */
public class ObjectPrimitiveArray {

    public static void main(String[] args) {
        long[] primitiveArray = new long[]{12, 100, 2929, 3232};
        Long[] objectArray = ArrayUtils.toObject(primitiveArray);

        Double[] doubleObjects = new Double[]{new Double(3.22), new Double(5.222), new Double(3.221)};
        double[] doublePrimitives = ArrayUtils.toPrimitive(doubleObjects);
    }
}
