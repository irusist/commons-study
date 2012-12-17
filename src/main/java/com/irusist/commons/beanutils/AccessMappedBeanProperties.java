package com.irusist.commons.beanutils;

import com.irusist.commons.beanutils.pojo.Apartment;
import com.irusist.commons.beanutils.pojo.Room;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * PropertyUtils.getMappedProperty(apartment, "rooms", "Dining Room");
 * PropertyUtils.getMappedProperty(apartment, "rooms(Dining Room)");
 * 都可以从apartment中取得rooms（Map类型）的键为Dining Room的值
 * User: zhulixin
 * Date: 12-11-30
 * Time: 上午11:22
 */
public class AccessMappedBeanProperties {

    public static void main(String[] args) {
        Room dining = new Room();
        dining.setArea(20);
        dining.setCarpeted(true);
        dining.setFurnished(true);

        Map rooms = new HashMap();
        rooms.put("Dining Room", dining);

        Apartment apartment = new Apartment();
        apartment.setRooms(rooms);

        Room room = null;
        try {
//            room = (Room) PropertyUtils.getMappedProperty(apartment, "rooms", "Dining Room");
            room = (Room) PropertyUtils.getMappedProperty(apartment, "rooms(Dining Room)");
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(room);
    }
}