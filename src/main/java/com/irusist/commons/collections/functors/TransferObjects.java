package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Transformer;

/**
 * Transformer是将一个对象转化为另一个对象，其中transform的参数不能改变
 * 相当于Commons Sandbox当中的UnaryPredicate
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午4:18
 */
public class TransferObjects {

    public static void main(String[] args) {
        Transformer joinArmy = new Transformer() {
            public Object transform(Object input) {
               //
                return null;
            }
        };
    }
}
