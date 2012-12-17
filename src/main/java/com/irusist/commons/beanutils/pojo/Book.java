package com.irusist.commons.beanutils.pojo;

import java.util.List;

/**
 * User: zhulixin
 * Date: 12-11-29
 * Time: 下午6:39
 */
public class Book {

    private String name;

    private Person author;

    private List<Chapter> chapters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
