package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * PropertyUtils.getSimpleProperty(object, property)
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午6:11
 */
public class AccessSimpleBeanProperties {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alex Wolfe");
        person.setFavoriteColor("Green");

        String name = null;
        String favoriteColor = null;
        try {
            name = (String) PropertyUtils.getSimpleProperty(person, "name");
            favoriteColor = (String) PropertyUtils.getSimpleProperty(person, "favoriteColor");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(name);
        System.out.println(favoriteColor);
    }
}
