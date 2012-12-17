package com.irusist.commons.collections;

import org.apache.commons.collections.collection.TypedCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Collection typedCollection = TypedCollection.decorate(existingList, String.class);
 * TypedCollection, TypedSet, TypedList, TypedMap, TypedBug, TypedBuffer
 * 与泛型类似
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:23
 */
public class CreateTypedCollectionsMaps {
    public static void main(String[] args) {
        List existingList = new ArrayList();
        Collection typedCollection = TypedCollection.decorate(existingList, String.class);

        typedCollection.add("STRING");
        typedCollection.add(28L);

    }
}
