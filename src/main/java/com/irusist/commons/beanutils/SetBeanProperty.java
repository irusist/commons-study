package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.*;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PropertyUtils.setProperty(object, property)可以设置object对象的property属性的值
 * 其中property可以是simple，nested，indexed，mapped的
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午2:51
 */
public class SetBeanProperty {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Blah");

        Book book1 = new Book();
        book1.setName("Blah");

        try {
            PropertyUtils.setProperty(book1, "name", "Some Apache Book");
            PropertyUtils.setProperty(book1, "author", new Person());
            PropertyUtils.setProperty(book1, "author.name", "Ken Coar");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(book1.getAuthor().getName());


        Book book2 = new Book();
        List<Chapter> chapters = new ArrayList<Chapter>();
        chapters.add(new Chapter());
        chapters.add(new Chapter());
        book2.setChapters(chapters);

        try {
            PropertyUtils.setProperty(book2, "name", "Apache:The Definitive Guide");
            PropertyUtils.setProperty(book2, "author", new Person());
            PropertyUtils.setProperty(book2, "author.name", "Laurie");
            PropertyUtils.setProperty(book2, "chapters[0].name", "Introduction");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("============================================");
        System.out.println(book2.getAuthor().getName());
        System.out.println(book2.getChapters().get(0).getName());

        Apartment apartment = new Apartment();
        Map<String, Room> rooms = new HashMap<String, Room>();
        rooms.put("livingRoom", new Room());
        apartment.setRooms(rooms);

        try {
            PropertyUtils.setProperty(apartment, "rooms(livingRoom).area", 12);
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("==============================");
        System.out.println(((Room)apartment.getRooms().get("livingRoom")).getArea());
    }
}
