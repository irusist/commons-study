package com.irusist.commons.collections;

import org.apache.commons.collections.map.CaseInsensitiveMap;

import java.util.Map;

/**
 * Map grades = new CaseInsensitiveMap();会将key保存为小写的
 * grades.get(key)会将key先转化为小写，再去读取数值。
 * User: zhulixin
 * Date: 12-12-10
 * Time: 下午2:12
 */
public class UseCaseInsensitiveMap {
    public static void main(String[] args) {
        Map grades = new CaseInsensitiveMap();
        grades.put("Fortney", "B-");
        grades.put("Puckett", "D+");
        grades.put("Flatt", "A-");

        String grade1 = (String) grades.get("puckett");
        String grade2 = (String) grades.get("FLATT");
        System.out.println(grade1);
        System.out.println(grade2);
    }
}

