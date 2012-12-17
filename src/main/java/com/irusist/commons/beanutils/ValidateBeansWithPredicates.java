package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Coach;
import com.irusist.commons.beanutils.pojo.Team;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.*;

/**
 * Predicate teamNotNull = new BeanPredicate("name", NotNullPredicate.getInstance());
 * validateTeam.evaluate(fish);
 * 其中Predicate有NotNullPredicate,EqualPredicate,InstanceofPredicate,AllPredicate,AnyPrecidate
 * 校验fish对象的某个属性是否满足某个条件，其中属性可以是simple，nested，indexed，mapped
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午3:23
 */
public class ValidateBeansWithPredicates {

    public static void main(String[] args) {
        Predicate teamNotNull = new BeanPredicate("name", NotNullPredicate.getInstance());

        Predicate coachFirstName = new BeanPredicate("coach.firstName",new EqualPredicate("Tom"));

        Predicate validateTeam = new AllPredicate(new Predicate[]{teamNotNull, coachFirstName});

        Team fish = new Team("Swordfish", new Coach("Tom", "O'Connell"));
        Team hens = new Team("Hens", new Coach("Bob", "McGarry"));

        boolean fishValid = validateTeam.evaluate(fish);
        boolean hensValid = validateTeam.evaluate(hens);

        System.out.println("Is Swordfish team valid?" + fishValid);
        System.out.println("Is Hens team valid?" + hensValid);


        Predicate example1 = new BeanPredicate("age", new EqualPredicate(new Integer(10)));

        Predicate example2 = new BeanPredicate("book[4].title", new InstanceofPredicate(String.class));

        Predicate equalA = new EqualPredicate("A");
        Predicate equalB = new EqualPredicate("B");
        Predicate equalC = new EqualPredicate("C");

        Predicate eitherABC = new AnyPredicate(new Predicate[]{equalA, equalB, equalC});

        Predicate example3 = new BeanPredicate("mode", eitherABC);

    }
}
