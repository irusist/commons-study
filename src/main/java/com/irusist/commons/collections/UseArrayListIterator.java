package com.irusist.commons.collections;

import org.apache.commons.collections.iterators.ArrayListIterator;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;

/**
 * ArrayListIterator iterator = ArrayListIterator(Object array, int startIndex, int endIndex)
 * iterator.nextIndex()返回下一个索引，从0开始
 * iterator.next()从startIndex的值
 * iterator.reset()
 * iterator.set(object),将上一次循环的值设置为object
 * iterator.reset()从startIndex开始
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午3:09
 */
public class UseArrayListIterator {

    public static void main(String[] args) {

        String[] strings = new String[]{"A", "B", "C", "D", "E", "F"};

        System.out.println(Array.get(strings, 1));

        ArrayListIterator iterator = new ArrayListIterator(strings, 3, 5);
        while (iterator.hasNext()){
            int index = iterator.nextIndex();
            String element = (String) iterator.next();
            System.out.println("Element at " + index + " : " + element);
        }

        System.out.println("================================");

        ArrayListIterator iterator1 = new ArrayListIterator(strings, 2);

        int index = iterator1.nextIndex();
        String element = (String) iterator1.next();
        System.out.println("Element at " + index + ": " + element);

        iterator1.set("G");
        System.out.println("Modifying index: " + index + "to G");

        index = iterator1.nextIndex();
        element = (String) iterator1.next();
        System.out.println("Element at " + index + ": " + element);

        iterator1.set("H");
        System.out.println("Modifying index: " + index + " to H");

        iterator1.reset();
        System.out.println("Reset");

        index = iterator1.nextIndex();
        element = (String) iterator1.next();
        System.out.println("Element at " + index + ": " + element);

        System.out.println(ArrayUtils.toString(strings));
    }
}
