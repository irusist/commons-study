package com.irusist.commons.lang;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * ArrayUtils.toMap():
 * 将多维数组转化成map
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午4:48
 */
public class MultiDimensionalArray2Map {

    public static void main(String[] args) {
        Object[] weightArray = new Object[][]{{"H",new Double(1.007)},
                                             {"He",new Double(4.002)},
                                             {"Li",new Double(6.941)}};
        Map weights = ArrayUtils.toMap(weightArray);
        Double hydrogenWeight = (Double)weights.get("H");
        System.out.println(hydrogenWeight);

    }
}
