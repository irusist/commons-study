package com.irusist.commons.collections;

import org.apache.commons.collections.map.LRUMap;

import java.util.Map;

/**
 * Map<String, Float> cache = new LRUMap(5);
 * 如果cache的大小超过了5个，再往里面加数据，则会删除最近最少使用的元素。（LRU算法）
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午3:37
 */
public class CreateLeastRecentlyUsedCache {

    public static void main(String[] args) {
        Map<String, Float> cache = new LRUMap(5);

        cache.put("MSFT", 0.03F);
        cache.put("TSC", 0.001F);
        cache.put("LU", 23.30F);
        cache.put("CSCO", 242.20F);
        cache.put("P", 10.23F);

        Float cscoPrice = cache.get("MSFT");
        Float msPrice = cache.get("CSCO");
        Float tscPrice = cache.get("TSC");
        Float luPrice = cache.get("LU");
        Float pPrice = cache.get("P");
        Float msPrice2 = cache.get("MSFT");

        cache.put("AA", 203.20F);

        if (!cache.containsKey("CSCO")) {
            System.out.println("As expected CSCO was discarded");
        }
    }
}
