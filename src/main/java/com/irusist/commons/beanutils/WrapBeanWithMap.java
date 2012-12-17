package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.BeanMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * BeanMap beanMap = new BeanMap(person);
 * BeanMap.getWriteMethod(),method.invoke()
 * BeanMAp.put(property, value)
 * BeanMap.getType(property)
 * BeanMap.get(property)
 * BeanMap.setBean(object)重新赋值bean
 * 对BeanMap操作其实操作的是底层的Bean。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午4:12
 */
public class WrapBeanWithMap {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Jim");
        person.setAge(28);
        person.setOccupation("Developer");

        BeanMap beanMap = new BeanMap(person);

        Method method = beanMap.getWriteMethod("age");
        try {
            method.invoke(person, new Integer(24));
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        beanMap.put("name", "John");

        Person person2 = new Person();
        person2.setName("Cindy");
        person2.setAge(39);
        person2.setOccupation("Transcriptionist");

        beanMap.setBean(person2);

        Class type = beanMap.getType("age");

        Set keys = beanMap.keySet();
        Iterator keyIterator = keys.iterator();
        while(keyIterator.hasNext()){
            String propertyName = (String)keyIterator.next();
            System.out.println("Property: " + propertyName +
                                ", Value: " + beanMap.get(propertyName) +
                                ", Type: " + beanMap.getType(propertyName));
        }
    }
}
