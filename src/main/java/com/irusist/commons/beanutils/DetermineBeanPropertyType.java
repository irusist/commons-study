package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Chapter;
import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * PropertyUtils.getPropertyType(object, property)取得object对象的property属性的类型，
 * 如果是嵌套的，则取最后一层的类型
 * PropertyUtils.getPropertyDescriptor(object, property)返回PropertyDescriptor对象
 * 可以通过getPropertyType，getWriteMethod，getReadMethod来取得相应的内容。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:43
 */
public class DetermineBeanPropertyType {

    public static void main(String[] args) {
        Book book = new Book();

        Chapter chapter = new Chapter();
        chapter.setName("Chapter 3 BeanUtils");
        chapter.setLength(new Integer(40));

        List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(chapter);

        book.setName("Jakarta Commons CookBook");
        book.setAuthor(new Person());
        book.setChapters(chapters);

        Class type = null;
        Method writeMethod = null;
        Class properType = null;
        Method readMethod = null;
        try {
            String property = "chapters[0].name";
            type = PropertyUtils.getPropertyType(book, property);
            PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(book, property);
            properType = descriptor.getPropertyType();
            writeMethod = descriptor.getWriteMethod();
            readMethod = descriptor.getReadMethod();
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("book.author type: " + type.getName());
        System.out.println(properType.getName());
        System.out.println(writeMethod.getName());
        System.out.println(readMethod.getName());
    }
}
