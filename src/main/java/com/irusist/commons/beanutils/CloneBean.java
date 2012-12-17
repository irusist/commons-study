package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtils.cloneBean(object)会生成object同一个类第一个对象，然后将object的属性全部copy到新的对象当中。
 * 他们的相同属性指向同一对象，不是clone的。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午2:42
 */
public class CloneBean {

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("Count of Monte Cristo");
        Person author = new Person();
        author.setName("aaa");

        Book book2 = null;
        try {
            // 相当于
//            Book book2 = book1.getClass().newInstance();
//            PropertyUtils.copyProperties(book1, book2);
            book2 = (Book) BeanUtils.cloneBean(book1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(book2.getAuthor() == book1.getAuthor());
    }
}
