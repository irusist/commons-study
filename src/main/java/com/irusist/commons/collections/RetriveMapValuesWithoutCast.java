package com.irusist.commons.collections;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * MapUtils.getDouble(numberMap, "D", Double.NaN);
 * 将numberMap的键为D的值，转化为Double,如果不能换成Double的，则返回Double.NaN
 * MapUtils.getNumber(map, key, defaultValue)返回Number类型
 * MapUtils.getLong(map, key, defaultValue)返回Long类型
 * MapUtils.getByte(map, key, defaultValue)返回Byte类型
 * MapUtils.getLongValue(map, key, defaultValue)返回long类型的基本类型
 * MapUtils.getShortValue(map, key, defaultValue)返回short类型的基本类型
 * MapUtils.getByteValue(map, key, defaultValue)返回byte类型的基本类型
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午5:18
 */
public class RetriveMapValuesWithoutCast {

    public static void main(String[] args) {
        Object[] mapArray = new Object[]{
                new Object[]{"A", new Double(2.0)},
                new Object[]{"B", new Double(0.223242)},
                new Object[]{"C", new Double(2828e4)},
                new Object[]{"D", "GARBAGE"}
        };

        Map numberMap = ArrayUtils.toMap(mapArray);
        double a = MapUtils.getDouble(numberMap, "A");
        double b = MapUtils.getDouble(numberMap, "B");
        double c = MapUtils.getDouble(numberMap, "C");
        double d = MapUtils.getDouble(numberMap, "D", Double.NaN);

        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("C = " + c);
        System.out.println("D = " + d);
    }
}
