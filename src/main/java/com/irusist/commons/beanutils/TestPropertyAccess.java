package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Chapter;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * PropertyUtils.isReadable(object, property)
 * PropertyUtils.isWritable(object, property)
 * 判断object的读方法和写方法是否可访问的，如果没有相应的属性，则返回false
 * 其中property可以是simple，nested，indexed，mapped的
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午3:06
 */
public class TestPropertyAccess {

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("Blah");
        String name = book1.getName();

        boolean nameReadable = PropertyUtils.isReadable(book1, "name");
        boolean nameWritable = PropertyUtils.isWriteable(book1, "name");

        System.out.println("Is name readable? " + nameReadable);
        System.out.println("Is name writable?" + nameWritable);

        System.out.println("==============================");

        Book book2 = new Book();
        List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(new Chapter());
        book2.setChapters(chapters);

        boolean isReadable = PropertyUtils.isReadable(book2, "chapters[0].name");
        boolean isWritable = PropertyUtils.isWriteable(book2, "chapters[0].name");
        System.out.println(isReadable);
        System.out.println(isWritable);

    }
}
