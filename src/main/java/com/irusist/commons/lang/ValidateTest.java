package com.irusist.commons.lang;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Validate:
 * 校验参数是否正确
 * User: zhulixin
 * Date: 12-11-27
 * Time: 下午6:36
 */
public class ValidateTest {

    public static void main(String[] args) {
        String str = null;
        List list = new ArrayList<String>();
        list.add(str);
        doSomething(2, new String[1],list);
    }

    public static void doSomething(int param1, Object[] param2, Collection param3){
        Validate.isTrue(param1 > 0, "param must be greater than zero");
        Validate.notEmpty(param2, "param2 must not be empty");
        Validate.notEmpty(param3, "param3 must not be empty");
        Validate.noNullElements(param3, "param3 connot contain null elements");
    }
}
