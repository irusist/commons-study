package com.irusist.commons.collections.util;

import com.irusist.commons.beanutils.pojo.Book;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午5:58
 */
public class BookComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        int comparison = -1;
        if(o1 instanceof Book && o2 instanceof Book){
            Book b1 = (Book)o1;
            Book b2 = (Book)o2;
            String b1Name = b1.getName();
            String b2Name= b2.getName();
            String b1Author = b1.getAuthor().getName();
            String b2Author = b2.getAuthor().getName();

            if(StringUtils.isNotEmpty(b1Name) &&
                    StringUtils.isNotEmpty(b2Name)){
                comparison = b1Name.compareTo(b2Name);
            }

            if(comparison == 0 &&
                    StringUtils.isNotEmpty(b1Author) &&
                    StringUtils.isNotEmpty(b2Author)){
                comparison = b1Author.compareTo(b2Author);
            }
        }
        return comparison;
    }
}
