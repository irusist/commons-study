package com.irusist.commons.xml.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhulixin
 */
public class Pages {

    private List<Page> pages = new ArrayList<Page>();

    public void addPage(Page page) {
        pages.add(page);
    }

    public List<Page> getPages() {
        return pages;
    }
}
