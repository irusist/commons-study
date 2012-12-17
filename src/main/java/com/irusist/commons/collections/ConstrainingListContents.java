package com.irusist.commons.collections;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.list.PredicatedList;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午3:02
 */
public class ConstrainingListContents {

    public static void main(String[] args) {
        Predicate onlyEven = new Predicate() {
            public boolean evaluate(Object object) {
                Integer integer = (Integer) object;
                return integer.intValue() % 2 == 0;
            }
        };

        List list = PredicatedList.decorate(new ArrayList(), onlyEven);

        /* 测试列子*/
        // 跑出IllegalArgumentException
        list.add(1);
        list.add(2);
        // 跑出IllegalArgumentException
        list.add(3);
        list.add(4);

    }
}
