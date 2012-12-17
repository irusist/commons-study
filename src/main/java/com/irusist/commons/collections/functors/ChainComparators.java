package com.irusist.commons.collections.functors;

import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.util.Arrays;

/**
 * ComparatorChain comparatorChain = new ComparatorChain();
 * comparatorChain.addComparator(new BeanComparator("name"));
 * comparatorChain.addComparator(new BeanComparator("id"));
 * comparatorChain.addComparator(new BeanComparator("age"), true);
 * 会一次按每个比较器进行比较，如果相同则比较下一个，其中addComparator方法的第二个参数表示是否逆序。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午6:23
 */
public class ChainComparators {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Payne");
        person1.setId("James");
        person1.setAge(21);

        Person person2 = new Person();
        person2.setName("Payne");
        person2.setId("James");
        person2.setAge(85);

        Person person3 = new Person();
        person3.setName("Payne");
        person3.setId("Susan");
        person3.setAge(29);

        Person[] persons = new Person[]{person1, person2, person3};

        ComparatorChain comparatorChain = new ComparatorChain();
        comparatorChain.addComparator(new BeanComparator("name"));
        comparatorChain.addComparator(new BeanComparator("id"));
        comparatorChain.addComparator(new BeanComparator("age"), true);

        Arrays.sort(persons, comparatorChain);
        for(Person person : persons){
            System.out.println(person.getName() + " " + person.getId() + " " + person.getAge());
        }
    }
}
