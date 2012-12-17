package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * PropertyUtils.copyProperty(dest, origin)
 * 将origin的属性拷贝到dest当中。拷贝的属性对象是同一个对象，不会进行copy。
 * 其中origin也可以是map，这样就按map的键来查找属性名称。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午2:28
 */
public class CopyBeanProperties {

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Prelude to Foundation");
        Person author = new Person();
        author.setName("Asimov");
        book.setAuthor(author);

        //TODO:嵌套的属性用map怎么赋值？
        Map mapProps = new HashMap();
        mapProps.put("name", "The Art of Computer Programming");
        mapProps.put("author", new Person());
        mapProps.put("author.name", "Knuth");

        Book destinationBook = new Book();
        try {
//            PropertyUtils.copyProperties(destinationBook, book);
              PropertyUtils.copyProperties(destinationBook, mapProps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(destinationBook.getName());
        System.out.println(book.getAuthor() == destinationBook.getAuthor());
    }
}
