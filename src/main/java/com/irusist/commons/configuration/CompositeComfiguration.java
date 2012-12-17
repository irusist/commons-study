package com.irusist.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationBuilder;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DefaultConfigurationBuilder;

import java.net.URL;

/**
 * ConfigurationBuilder builder = new DefaultConfigurationBuilder(configURL);
 * Configuration config = builder.getConfiguration();
 * System.out.println("Timeout: " + config.getFloat("timeout"));
 * 其中获取属性的覆盖顺序是：在configURL中最开始定义的properties元素会覆盖下面的properties元素的属性
 * 在configURL的文件中，configuration节点下除了定义properties元素，还能定义dom4j元素，如：
 * <configuration>
 *     <dom4j fileName="test.xml" />
 * </configuration>
 *
 * @author zhulixin
 */
public class CompositeComfiguration {

    public static void main(String[] args) {

        URL configURL = CompositeComfiguration.class.getResource("/configuration/config/configuration.xml");
        try {
            ConfigurationBuilder builder = new DefaultConfigurationBuilder(configURL);
            Configuration config = builder.getConfiguration();
            System.out.println("Timeout: " + config.getFloat("timeout"));
            System.out.println("Max Threads: " + config.getString("threads.max"));
            System.out.println("Name: " + config.getString("name"));
            System.out.println("Speed: " + config.getInt("speed"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
