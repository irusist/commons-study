package com.irusist.commons.collections;

import org.apache.commons.collections.iterators.UniqueFilterIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator uniqueIterator = new UniqueFilterIterator(medalsList.iterator());
 * uniqueIterator返回medalsList的去掉重复的数据
 * 它等价于Iterator uniqueIterator = new FilterIterator(medalsList.interator(),
 * UniquePredicate.getInstance())
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午5:46
 */
public class IterateThroughDistinctElements {

    public static void main(String[] args) {
        String[] medals = new String[]{"gold", "silver", "silver", "gold", "bronze"};
        List medalsList = Arrays.asList(medals);

        Iterator uniqueIterator = new UniqueFilterIterator(medalsList.iterator());

        while (uniqueIterator.hasNext()){
            System.out.println("Unique Medal: " + uniqueIterator.next());
        }

    }
}
