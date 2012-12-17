package com.irusist.commons.collections.functors;

import com.irusist.commons.collections.pojo.Product;
import org.apache.commons.collections.Closure;

/**
 * Closure的execute方法可以改变传进来参数input的值，而Transformer的transform则不能
 * 它与Commons Sandbox的UnaryProcedure类似。
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午6:06
 */
public class WriteClosure {

    public static void main(String[] args) {
        Closure discount = new Closure() {
            int count = 0;

            public int getCount(){
                return count;
            }

            public void execute(Object input) {
                count ++;
                Product product = (Product) input;
                product.setPrice(product.getPrice() * 0.9);
                System.out.println(count);
            }
        };

        Product shoes = new Product();
        shoes.setName("Fancy Shoes");
        shoes.setPrice(120.00);
        System.out.println("Shoes before discount:" + shoes.getPrice());

        discount.execute(shoes);
        System.out.println("Shoes after discount:" + shoes.getPrice());

        discount.execute(shoes);
        discount.execute(shoes);
        System.out.println("after discount:" + shoes.getPrice());
    }
}
