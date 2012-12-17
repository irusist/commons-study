package com.irusist.commons.collections;

import com.irusist.commons.collections.pojo.Album;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Set;

/**
 * User: zhulixin
 * Date: 12-12-5
 * Time: 下午5:56
 */
public class UseBag {

    private Bag inventoryBag = new HashBag();
    private Album album1 = new Album("Radiohead", "OK Computer");
    private Album album2 = new Album("Kraftweek", "The Man-Machine");
    private Album album3 = new Album("Charlie Porker", "Now's the Time");
    private Album album4 = new Album("ABBa", "ABBA - Gold: Greatest Hits");

    public static void main(String[] args) {
        Bag bag = new HashBag();
        bag.add("TEST1", 100);
        bag.add("TEST2", 500);

        int test1Count = bag.getCount("TEST1");
        int test2Count = bag.getCount("TEST2");

        System.out.println("Counts:TEST1: " + test1Count + ",TEST2: " + test2Count);

        bag.remove("TEST1", 1);
        bag.remove("TEST2", 10);

        test1Count = bag.getCount("TEST1");
        test2Count = bag.getCount("TEST2");
        System.out.println("Counts: TEST1: " + test1Count + ", TEST2: " + test2Count);

        System.out.println("==========================");

        UseBag example = new UseBag();
        example.start();
    }

    private void start() {
        populateInventory();

        System.out.println("Inventory before Transactions");
        printAlbums(inventoryBag);
        printSeparator();

        Bag shoppingCart1 = new HashBag();
        shoppingCart1.add(album4, 500);
        shoppingCart1.add(album3, 150);
        shoppingCart1.add(album1, 2);
        shoppingCart1.add(album1, 2);
    }

    private void printSeparator() {
        System.out.println(StringUtils.repeat("*", 65));
    }

    private void printAlbums(Bag albumBag) {
        // 相当于获取HashMap的key的集合
        Set albums = albumBag.uniqueSet();
        Iterator albumIterator = albums.iterator();
        while (albumIterator.hasNext()) {
            Album album = (Album) albumIterator.next();
            NumberFormat format = NumberFormat.getInstance();
            format.setMinimumIntegerDigits(3);
            format.setMaximumFractionDigits(0);
            System.out.println("\t" + format.format(albumBag.getCount(album)) + "-" + album.getBand());
        }
    }

    private void populateInventory() {
        inventoryBag.add(album1, 200);
        inventoryBag.add(album2, 100);
        inventoryBag.add(album3, 500);
        inventoryBag.add(album4, 900);
    }
}
