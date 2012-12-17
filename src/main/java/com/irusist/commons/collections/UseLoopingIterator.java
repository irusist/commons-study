package com.irusist.commons.collections;

import org.apache.commons.collections.iterators.LoopingIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * LoopingIterator(Collection collection)的next()方法循环获取collection的元素，
 * LoopingIterator实现ResettableIterator接口，调用reset则重置到cllection的第一个元素。
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午2:57
 */
public class UseLoopingIterator {

    public static void main(String[] args) {
        List<String> drivers = new ArrayList<String>();
        drivers.add("Chris");
        drivers.add("Sean");
        drivers.add("Kathy");

        LoopingIterator loopingIterator = new LoopingIterator(drivers);

        for(int i=0; i<=5; i++){
            String driver = (String) loopingIterator.next();
            System.out.println("Driver for Day " + i + ": " + driver);
        }
    }
}
