package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;

/**
 * ChainedTransformer(Transformer[] transformers),会依次执行transformers中的Transformer.transform()方法。
 * 相当于Commons Sandbox当中的CompositeUnaryFunction
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午4:27
 */
public class CreateTransformerChain {

    public static void main(String[] args) {
        Transformer multiply = new Transformer() {
            public Object transform(Object input) {
                Long number = (Long) input;
                return number * 100;
            }
        };

        Transformer increment = new Transformer() {
            public Object transform(Object input) {
                Long number = (Long) input;
                return number + 1;
            }
        };

        Transformer[] chainElements = new Transformer[]{multiply, increment};
        Transformer chain = new ChainedTransformer(chainElements);

        Long original = new Long(34);
        Object result = chain.transform(original);

        System.out.println("Original: " + original);
        System.out.println("Result: " + result);
    }
}
