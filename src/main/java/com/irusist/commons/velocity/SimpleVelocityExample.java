package com.irusist.commons.velocity;

import com.irusist.commons.velocity.pojo.Magazine;
import com.irusist.commons.velocity.pojo.Person;
import com.irusist.commons.velocity.pojo.Subscription;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.*;
import java.util.Date;

/**
 * velocity指令：
 * ${sub} VelocityContext中sub的值
 * ${sub.endDate} sub.getEndDate()的值
 * ${!customer.firstName}  如果customer.getFirstName()返回null，则输出空字符串 ,被称为quiet reference(静态引用)
 * ${customer.firstName} 如果customer.getFirstName()返回null，则输出字符串null
 * #set
 *
 * @author zhulixin
 */
public class SimpleVelocityExample {

    public static void main(String[] args) throws Exception {
        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("subscription", testSubscription());

        InputStream inputStream = SimpleVelocityExample.class.getResourceAsStream("/velocity/config/renew.vm");

        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "test", inputStream);

        System.out.println(writer.toString());
        inputStream.close();
    }


    private static Object testSubscription() {
        Subscription subscription = new Subscription();
        subscription.setEndDate(new Date());

        Person customer = new Person();
        customer.setFirstName("Tim");
        customer.setId("22324");
        subscription.setCustomer(customer);

        Magazine magazine = new Magazine();
        magazine.setTitle("Science World expires");
        magazine.setBaseUrl("http://www.scienceworld.com");
        subscription.setMagazine(magazine);
        return subscription;
    }
}
