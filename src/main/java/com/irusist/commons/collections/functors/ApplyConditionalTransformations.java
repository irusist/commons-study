package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.NOPTransformer;
import org.apache.commons.collections.functors.SwitchTransformer;

/**
 * Transformer transformer = SwitchTransformer(Predicate[], Transformer[], Transformer defaultTransformer)
 * transformer.transform(object)对object执行Predicate[]当中的，如果匹配了其中一个，
 * 则执行Transformer[]当中的方法，如果一个都没匹配，则调用defaultTransformer,
 * defaultTransformer一般设置为NOPTransformer.getInstance()
 * 相当于Commons Sandbox当中的ConditionalUnaryFunction
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午4:41
 */
public class ApplyConditionalTransformations {

    public static void main(String[] args) {
        Transformer oddTransform = new Transformer(){
            public Object transform(Object input) {
                Integer number = (Integer) input;
                return number * 2;
            }
        };

        Transformer evenTransform = new Transformer(){
            public Object transform(Object input) {
                Integer number = (Integer) input;
                return number * 3;
            }
        };

        Predicate isOdd = new Predicate() {
            public boolean evaluate(Object object) {
                Integer number = (Integer) object;
                return number % 2 != 0;
            }
        };

        Predicate isEven = new Predicate() {
            public boolean evaluate(Object object) {
                Integer number = (Integer) object;
                return number % 2 == 0;
            }
        };

        Predicate[] pArray = new Predicate[]{isOdd, isEven};
        Transformer[] tArray = new Transformer[]{oddTransform, evenTransform};

        Transformer predicateTransform = new SwitchTransformer(pArray, tArray, NOPTransformer.getInstance());

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        System.out.println("Transform of 1 = " + predicateTransform.transform(one));
        System.out.println("Transform of 2 = " + predicateTransform.transform(two));
        System.out.println("Transform of 3 = " + predicateTransform.transform(three));
        System.out.println("Transform of 4 = " + predicateTransform.transform(four));
    }
}
