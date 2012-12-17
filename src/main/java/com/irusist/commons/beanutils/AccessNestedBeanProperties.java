package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * PropertyUtils.getNestedProperty(book, "author.name")
 * 取嵌套的属性
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午6:40
 */
public class AccessNestedBeanProperties {

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Emerson's Essays");

        Person person = new Person();
        person.setName("Raplph Waldo Emerson");
        book.setAuthor(person);

        String authorName = null;
        try {
            authorName = (String) PropertyUtils.getNestedProperty(book, "author.name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(authorName);
    }
}
