package com.irusist.commons.collections;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Transformer transformChain = new ChainedTransformer(new Transformer[]{multiplyTransform, subtractTransform});
 * CollectionUtils.transform(list, transformChain)
 * 对list依次进行transformChain当中的转换
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午3:24
 */
public class TransformCollections {

    public static void main(String[] args) {
        Transformer reversingTransformer = new Transformer() {
            public Object transform(Object input) {
                String string = (String) input;
                return StringUtils.reverse(string);
            }
        };

        String[] array = new String[]{"Aznar", "Blair", "Chirac", "Putin", "Bush"};
        List stringList = Arrays.asList(ArrayUtils.clone(array));
        CollectionUtils.transform(stringList, reversingTransformer);

        System.out.println("Original: " + ArrayUtils.toString(array));
        System.out.println("Transformed: " + ArrayUtils.toString(stringList));

        System.out.println("==============================");
        Transformer multiplyTransform = new Transformer() {
            public Object transform(Object input) {
                Integer integer = (Integer) input;
                return integer * 10;
            }
        };

        Transformer subtractTransform = new Transformer() {
            public Object transform(Object input) {
                Integer integer = (Integer) input;
                return integer - 20;
            }
        };

        Transformer transformChain = new ChainedTransformer(new Transformer[]{multiplyTransform, subtractTransform});
        int[] ias = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        List intList = Arrays.asList(ArrayUtils.toObject(ias));

        CollectionUtils.transform(intList, transformChain);
        System.out.println("Original: " + ArrayUtils.toString(ias));
        System.out.println("Transformed: " + ArrayUtils.toString(intList));

    }
}
