package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtils.setProperty(object, property)
 * BeanUtils.getProperty(object, property)
 * 可以获取object的int类型的属性，内部通过IntegerConverter来转化成String。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午5:29
 */
public class GetAndSetProperty {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(45);
        person.setName("Donald");
        person.setOccupation("Salesman");

        try {
            String ageString = BeanUtils.getProperty(person, "age");
            System.out.println(ageString);
            BeanUtils.setProperty(person, "age", "50");
            System.out.println(BeanUtils.getProperty(person, "age"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
