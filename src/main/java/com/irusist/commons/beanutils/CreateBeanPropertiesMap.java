package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * PropertyUtils.describe(object)将object的属性映射成他的属性为key的map
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午3:53
 */
public class CreateBeanPropertiesMap {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Some Dude");

        Book book = new Book();
        book.setName("Some Silly Computer Book");
        book.setAuthor(person);

        Map bookMap = null;
        Map authorMap = null;
        try {
            bookMap = PropertyUtils.describe(book);
            authorMap = PropertyUtils.describe(bookMap.get("author"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("Book Name: " + bookMap.get("name"));
        System.out.println("Author Name: " + authorMap.get("name"));
    }
}
