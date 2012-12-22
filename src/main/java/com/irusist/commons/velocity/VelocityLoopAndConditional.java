package com.irusist.commons.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import com.irusist.commons.velocity.pojo.Airport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * #foreach($value in $list)
 *      $velocityCount  # 表示循环的索引
 * #end
 *
 * #foreach可以用在数组，Enumeration，List和Set上
 *
 * #if(condition)
 *
 * #elseif
 *
 * #else
 *
 * #end
 *
 * $someMap[$key] 用来获取一个map的key的值
 *
 * @author zhulixin
 */
public class VelocityLoopAndConditional {

    public static void main(String[] args) throws Exception {
        Velocity.init();
        List airports = new ArrayList();
        airports.add(new Airport("ATL", "Hartsfield Atlanta", 76876128, "US"));
        airports.add(new Airport("ORD", "Chicago O'Hare", 66501496, "US"));
        airports.add(new Airport("LHR", "London Heathrow", 63338649, "UK"));
        airports.add(new Airport("HND", "Tokyo-Haneda", 61079478, "JP"));
        airports.add(new Airport("LAX", "Los Angeles", 56198447, "US"));
        airports.add(new Airport("DFW", "Dallas/Fort Worth", 52826304, "US"));

        VelocityContext context = new VelocityContext();
        context.put("airports", airports);
        context.put("countryCode", "US");

        InputStream inputStream = VelocityLoopAndConditional.class.getResourceAsStream("/velocity/config/loopAndConditional.vm");
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "test", reader);

        System.out.println(writer.toString());
        inputStream.close();

    }
}
