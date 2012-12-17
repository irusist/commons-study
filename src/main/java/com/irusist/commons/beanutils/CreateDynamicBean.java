package com.irusist.commons.beanutils;


import org.apache.commons.beanutils.*;

import java.lang.reflect.InvocationTargetException;

/**
 * DynaProperty用来创建动态的属性
 * BasicDynaClass politicianClass = new BasicDynaClass("politician", BasicDynaBean.class, beanProperties);创建Class对象
 * politicianClass.newInstance()生成一个BasicDynaBean
 * 对BasicDynaBean的操作有：
 * politician.set("name", "Tony Blair");设置属性值
 * PropertyUtils.setProperty(politician, "name", "John Major");设置属性值
 * politician.get("name")获取simple的属性值
 * politician.get("name", int)获取indexed的属性值
 * politician.get("name", string)获取mapped的属性值
 * politician.remove("name",string)删除mapped属性的某个值
 * politician.contains("name",string)判断mapped属性是否包含某个key
 * User: zhulixin
 * Date: 12-11-30
 * Time: 下午5:09
 */
public class CreateDynamicBean {

    public static void main(String[] args) {
        DynaProperty[] beanProperties = new DynaProperty[]{
                new DynaProperty("name", String.class),
//                new DynaProperty("party", Party)
                new DynaProperty("votes", Long.class)
        };

        BasicDynaClass politicianClass = new BasicDynaClass("politician", BasicDynaBean.class, beanProperties);

        DynaBean politician = null;
        try {
            politician = politicianClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        politician.set("name", "Tony Blair");
        //politician.set("party", Party.LABOUR);
        politician.set("votes", new Long(500000));

        System.out.println(politician.get("name"));
        System.out.println(politician.get("votes"));

        try {
            PropertyUtils.setProperty(politician, "name", "John Major");
         //   PropertyUtils.setProperty(politician, "party", Party.TORY);
            PropertyUtils.setProperty(politician, "votes", new Long(5000000));
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("=======================");
        System.out.println(politician.get("name"));
        System.out.println(politician.get("votes"));
    }
}
