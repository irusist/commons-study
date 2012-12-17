package com.irusist.commons.collections.functors;

import com.irusist.commons.beanutils.pojo.Book;
import com.irusist.commons.beanutils.pojo.Person;
import com.irusist.commons.collections.util.BookComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator reverseComparator = new ReverseComparator(bookComparator);
 * 获得的reverseComparator是bookComparator排序的逆序
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午5:55
 */
public class ReverseComparator {

    public static void main(String[] args) {
        Comparator bookComparator = new BookComparator();
        Comparator reverseComparator = new org.apache.commons.collections.comparators.ReverseComparator(bookComparator);

        List<Book> books = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setName("TitleA");
        Person author1 = new Person();
        author1.setName("John");
        book1.setAuthor(author1);
        books.add(book1);

        Book book2 = new Book();
        book2.setName("TitleB");
        Person author2 = new Person();
        author2.setName("Donald");
        book2.setAuthor(author2);
        books.add(book2);

        Book book3 = new Book();
        book3.setName("TitleA");
        Person author3 = new Person();
        author3.setName("Doug");
        book3.setAuthor(author3);
        books.add(book3);

        Collections.sort(books, reverseComparator);

        for(Book book : books){
            System.out.println(book.getName() + ": " + book.getAuthor().getName());
        }
    }
}
