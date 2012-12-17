package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.*;

/**
 * AndPredicate(Predicate, Predicate),2个Predicate都是true才返回true
 * OrPredicate(Predicate, Predicate),只要有一个Predicate返回true就返回true
 * AllPredicate(Predicate[]),所有的Predicate[]中的都返回true才返回true
 * OnePredicate(Predicate[])，Predicate[]中只有一个返回true才返回true，否则返回false
 * AnyPredicate(Predicate[]),Predicate[]中只要有一个返回true就返回true
 * NonePredicate(Predicate[])，Predicate[]中有一个返回true就返回false，否则返回true
 * User: zhulixin
 * Date: 12-12-4
 * Time: 下午3:20
 */
public class CreateCompositePredicate {

    public static void main(String[] args) {

        Predicate isTim = new EqualPredicate("Tim");
        Predicate isDouble = new InstanceofPredicate(Double.class);
        Predicate isNotNull = NotNullPredicate.getInstance();

        Predicate[] predicates = new Predicate[] {isTim, isDouble, isNotNull};

        Predicate andPredicate = new AndPredicate(isTim, isNotNull);
        Predicate orPredicate = new OrPredicate(isTim, isNotNull);

        Predicate allPredicate = new AllPredicate(predicates);
        Predicate onePredicate = new OnePredicate(predicates);

        System.out.println("'Tim' and not null ?:" + andPredicate.evaluate("Tim"));
        System.out.println("'Tim' or not null?" + orPredicate.evaluate(new Long(3)));

        System.out.println("'Tim' , not null,and Double:?" + allPredicate.evaluate("Impossible"));
        System.out.println("'Tim', not null,or Double?" + onePredicate.evaluate("Impossible"));

    }
}
