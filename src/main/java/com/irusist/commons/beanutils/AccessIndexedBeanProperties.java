package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Chapter;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * PropertyUtils.getIndexedProperty(object, "chapters[0]")
 * PropertyUtils.getIndexedProperty(object, "chapters", 0)
 * 都可以取得object对象的chapters字段的第一个元素，用第二个能避免多余的错误。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:11
 */
public class AccessIndexedBeanProperties {

    public static void main(String[] args) {
        Book book = new Book();

        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();
        book.setChapters(new ArrayList<Chapter>());
        book.getChapters().add(chapter1);
        book.getChapters().add(chapter2);

        Chapter chapter = null;
        try {
            chapter = (Chapter) PropertyUtils.getIndexedProperty(book, "chapters[0]");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(chapter);
    }
}
