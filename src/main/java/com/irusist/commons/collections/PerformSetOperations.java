package com.irusist.commons.collections;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * CollectionUtils.union(a, b)返回a,b出现的所有元素，只显示一次
 * CollectionUtils.intersection(a, b)返回a, b中的交集
 * CollectionUtils.disjunction(a, b)返回在a, b中不重复的元素
 * CollectionUtils.subtract(a, b)返回在a出现但不在b出现的元素
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午5:04
 */
public class PerformSetOperations {

    public static void main(String[] args) {
        String[] arrayA = new String[]{"1", "2", "3", "4", "5"};
        String[] arrayB = new String[]{"3", "4", "5", "6", "7"};

        List a = Arrays.asList(arrayA);
        List b = Arrays.asList(arrayB);

        // [1, 2, 3, 4, 5, 6, 7]
        List union = (List)CollectionUtils.union(a, b);
        // [3, 4, 5]
        List intersection = (List)CollectionUtils.intersection(a, b);
        // [1, 2, 6, 7]
        List disjunction = (List)CollectionUtils.disjunction(a, b);
        // [1, 2]
        List subtract = (List)CollectionUtils.subtract(a, b);

        Collections.sort(union);
        Collections.sort(intersection);
        Collections.sort(disjunction);
        Collections.sort(subtract);

        System.out.println("A: " + ArrayUtils.toString(a));
        System.out.println("B: " + ArrayUtils.toString(b));
        System.out.println("Union: " + ArrayUtils.toString(union));
        System.out.println("Intersection: " + ArrayUtils.toString(intersection));
        System.out.println("Disjunction: " + ArrayUtils.toString(disjunction));
        System.out.println("Subtract: " + ArrayUtils.toString(subtract));
    }
}
