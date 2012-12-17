package com.irusist.commons.collections;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * MultiMap map = new MultiValueMap();
 * map.put(key, value)
 * map.put(key, value)
 * 这样在map.get(key)，map中同一个key得到的是collection
 * map.values()得到的是所有value组成的collection
 * User: zhulixin
 * Date: 12-12-10
 * Time: 上午11:51
 */
public class StoreMultipleValuesInAMap {

    public static void main(String[] args) {
        MultiMap map = new MultiValueMap();
        map.put("ONE", "TEST");
        map.put("TWO", "PICNIC");

        map.put("ONE", "HELLO");
        map.put("TWO", "TESTIMONY");


        Set keySet = map.keySet();
        Iterator keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            System.out.println("Key : " + key + ", ");

            Collection values = (Collection) map.get(key);
            Iterator valuesIterator = values.iterator();
            while (valuesIterator.hasNext()) {
                System.out.println("Value: " + valuesIterator.next() + ". ");
            }
            System.out.println();
        }

        System.out.println("=============================================");
        MultiMap map2 = new MultiValueMap();
        map2.put("ONE", "TEST");
        map2.put("ONE", "WAR");
        map2.put("ONE", "CAR");
        map2.put("ONE", "WEST");

        map2.put("TWO", "SKY");
        map2.put("TWO", "WEST");
        map2.put("TWO", "SCHOOL");

        map2.remove("ONE", "WAR");
        map2.remove("ONE", "CAR");

        Collection oneCollection = (Collection) map2.get("ONE");
        System.out.println(oneCollection);

        Collection values = map2.values();
        System.out.println(values);
    }
}
