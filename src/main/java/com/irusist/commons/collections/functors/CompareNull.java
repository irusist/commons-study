package com.irusist.commons.collections.functors;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import com.irusist.commons.collections.util.BookComparator;
import org.apache.commons.collections.comparators.NullComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator nullComparator = new NullComparator(bookComparator, false);
 * 其中bookComparator是一个比较器，如果传递第二个参数为true，则将null放在最后，否则放在最前
 * 默认的值为true，将null放在最后。
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午6:38
 */
public class CompareNull {

    public static void main(String[] args) {
        Comparator bookComparator = new BookComparator();
        Comparator nullComparator = new NullComparator(bookComparator);

        Book book1 = new Book();
        book1.setName("A");
        Person author1 = new Person();
        author1.setName("1");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setName("B");
        Person author2 = new Person();
        author2.setName("2");
        book2.setAuthor(author2);

        Book[] bookArray = new Book[]{book1, null , book2};
        Arrays.sort(bookArray, nullComparator);

        for(Book book : bookArray){
            System.out.println(book);
        }
    }
}
