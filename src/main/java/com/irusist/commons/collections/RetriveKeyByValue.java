package com.irusist.commons.collections;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

/**
 * BidiMap bidiMap = new DualHashBidiMap();
 * bidiMap.put(key, value)
 * bidiMap.get(key)返回key的值
 * bidiMap.inverseBidiMap().get(value)返回value的键
 * bidiMap.getKey(value)返回value的键
 * bidiMap.put(key, value1)会替换key的键为value1
 * bidiMap.put(key2, value)会替换value的键为key2
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午1:53
 */
public class RetriveKeyByValue {

    public static void main(String[] args) {
        BidiMap bidiMap = new DualHashBidiMap();
        bidiMap.put("il", "Illinois");
        bidiMap.put("sz", "Arizona");
        bidiMap.put("va", "Virginia");

        String vaAbbreviation = (String)bidiMap.inverseBidiMap().get("Virginia");
        String illinoisName = (String)bidiMap.get("il");
        String arizona = (String)bidiMap.getKey("sz");

        System.out.println(vaAbbreviation);
        System.out.println(illinoisName);
        System.out.println(arizona);

        System.out.println("==========================================");

        BidiMap bm = new DualHashBidiMap();
        bm.put("one", "red");
        bm.put("two", "green");
        bm.put("three", "blue");

        bm.put("one", "black");

        bm.put("five", "green");
        // 返回{five:green: one:black, three:blue}
        System.out.println(bm);
    }
}
