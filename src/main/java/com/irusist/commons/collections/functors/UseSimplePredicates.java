package com.irusist.commons.collections.functors;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.*;

/**
 *  Predicate nameJohn = new EqualPredicate("John");
 *  nameJohn.evaluate(name)判断name是否等于John
 *  有以下的Predicate:
 *  EqualPredicate(Object object),利用equals判断是否等于object
 *  IdentityPredicate(object) ，利用==判断是否等于object
 *  NotPredicate(Predicate),返回一个Predicate的相反的结果
 *  InstanceofPredicate(Class),返回是否属于Class类型
 *  NullPredicate(),判断某个对象是否为null
 *  NullIsTruePredicate(Predicate)，如果某个对象是null，则返回true，否则执行传入的Predicate.evaluate()
 *  NotNullPredicate(),判断某个对象不是null
 *  NullIsFalsePredicate(Predicate),如果某个对象是null，则返回false，否则执行传入的Predicate.evaluate()
 *  TruePredicate(),固定返回true
 *  FalsePredicate(),固定返回false
 *  UniquePredicate(),内部保存了一个hashset，如果第一次比较则返回true，下次再比较同一对象就返回false，可
 *  用作distinct对象。
 *
 *
 *  可以自己实现Predicate实现自己的类。
 * User: zhulixin
 * Date: 12-12-1
 * Time: 上午11:46
 */
public class UseSimplePredicates {

    public static void main(String[] args) {
        String name = "Tim";

        Predicate nameJohn = new EqualPredicate("John");
        Predicate nameTim = new EqualPredicate("Tim");

        Predicate instanceString = new InstanceofPredicate(String.class);
        Predicate instanceDouble = new InstanceofPredicate(Double.class);

        System.out.println("Is Name John?: " + nameJohn.evaluate(name));
        System.out.println("Is Name Tim?: " + nameTim.evaluate(name));
        System.out.println("Is this a String ?: " + instanceString.evaluate(name));
        System.out.println("Is this a Double ?: " + instanceDouble.evaluate(name));

        System.out.println("===================================");

        String testName = "Ben";
        Predicate equals = new EqualPredicate(testName);
        Predicate notEquals = new NotPredicate(equals);
        Predicate identity = new IdentityPredicate(testName);

        System.out.println("Does name equal 'Ben' ? " + equals.evaluate("Ben"));
        System.out.println("Is object 'Ben' ?" + identity.evaluate(testName));
        System.out.println("Does name equal 'Time' ?" + equals.evaluate("Tim"));
        System.out.println("Does name not equal 'Tim'? " + notEquals.evaluate("Tim"));
        System.out.println("Is object 'Tim' ?" + identity.evaluate("Tim"));

        System.out.println("=========================================");

        String nullString = null;
        Double testDouble = new Double(3.3);

        Predicate isString = new InstanceofPredicate(String.class);
        Predicate isLong = new InstanceofPredicate(Long.class);
        Predicate isNumber = new InstanceofPredicate(Number.class);

        Predicate isNotNull = NotNullPredicate.getInstance();
        Predicate isNull = NullPredicate.getInstance();

        Predicate unique = new UniquePredicate();

        System.out.println("'nullString' not null?" + isNotNull.evaluate(nullString));
        System.out.println("'nullString' null ?" + isNull.evaluate(nullString));
        System.out.println("'testDouble' a String?:" + isString.evaluate(testDouble));
        System.out.println("'testDouble' a Long ?" + isLong.evaluate(testDouble) );
        System.out.println("'testDouble' a Number? " + isNumber.evaluate(testDouble) );

        System.out.println("'A' Unique?" + unique.evaluate("A"));
        System.out.println("'C' Unique?" + unique.evaluate("C"));
        System.out.println("'A' Unique?" + unique.evaluate("A"));
        System.out.println("'B' Unique?" + unique.evaluate("B"));
    }
}
