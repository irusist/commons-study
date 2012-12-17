package com.irusist.commons.collections;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * CollectionUtils.cardinality("B", stringList);返回“B”在stringList出现的次数
 * CollectionUtils.countMatches(stringList, equalPredicate)返回在stringList中满足equalPredicate
 * 的个数
 * CollectionUtils.getCardinalityMap(stringList2)返回stringList2中值，及对应个数的一个map
 * 与Bag类似
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午4:41
 */
public class CountCollectionObjects {
    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C", "C", "B", "B"};
        List stringList = Arrays.asList(array);

        Predicate equalPredicate = new EqualPredicate("C");

        int numberCs = CollectionUtils.countMatches(stringList, equalPredicate);
        int numberBs = CollectionUtils.cardinality("B", stringList);

        System.out.println("List: " + ArrayUtils.toString(array));
        System.out.println("Number of Cs: " + numberCs);
        System.out.println("Number of Bs: " + numberBs);
        System.out.println("=============================");
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List intList = Arrays.asList(ArrayUtils.toObject(array2));
        Predicate isEvenPredicate = new Predicate() {
            public boolean evaluate(Object object) {
                Integer integer = (Integer) object;
                return integer % 2 == 0;
            }
        };

        int numberEven = CollectionUtils.countMatches(intList, isEvenPredicate);
        System.out.println("List: " + ArrayUtils.toString(array2));
        System.out.println("Number of Even Numbers: " + numberEven);
        System.out.println("======================================");
        String[] array3 = new String[]{"Red", "Blue", "Blue", "Yellow", "Red", "Blcak"};
        List stringList2 = Arrays.asList(array3);

        Map cardinalityMap = CollectionUtils.getCardinalityMap(stringList2);
        System.out.println("List: " + ArrayUtils.toString(array3));
        System.out.println("Cardinality Map:\n");
        MapUtils.debugPrint(System.out, null,cardinalityMap);
    }
}
