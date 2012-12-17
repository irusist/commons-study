package com.irusist.commons.collections;

import com.irusist.commons.collections.util.StockQuoteTransformer;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *  Map lazyNames = LazyMap.decorate(names, reverseString);
 *  lazyNames.get(key)时，
 *  如果key的值不存在，则调用value = reverseString.transform(key)，将names.put(key, value),返回value
 *  如果key的值存在，则直接返回names.get(key)
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午3:52
 */
public class UseLazyMap {
    public static void main(String[] args) throws Exception {
        Transformer reverseString = new Transformer() {
            public Object transform(Object input) {
                String name = (String) input;
                return StringUtils.reverse(name);
            }
        };

        Map names = new HashMap();
        Map lazyNames = LazyMap.decorate(names, reverseString);

        String name = (String) lazyNames.get("Thomas");
        System.out.println("Key: Thomas,Value: " + name);

        name = (String) lazyNames.get("Susan");
        System.out.println("Key: SUsan,Value: " + name);

        System.out.println("======================================");
        Map stockQuotes = new LRUMap(5);
        StockQuoteTransformer sqTransformer = new StockQuoteTransformer();
        sqTransformer.setQuoteURL(new URL("http://quotes.company.com"));
        sqTransformer.setTimeout(5000);

        stockQuotes = LazyMap.decorate(stockQuotes, sqTransformer);

        Float price = (Float) stockQuotes.get("CSCO");
        price = (Float) stockQuotes.get("MSFT");
        price = (Float) stockQuotes.get("TSC");
        price = (Float) stockQuotes.get("LU");
        price = (Float) stockQuotes.get("P");
        price = (Float) stockQuotes.get("P");
        price = (Float) stockQuotes.get("MSFT");
        price = (Float) stockQuotes.get("LU");

        price = (Float) stockQuotes.get("AA");

        if(!stockQuotes.containsKey("CSCO")) {
            System.out.println("As excepted CSCO was discarded");
        }
    }
}
