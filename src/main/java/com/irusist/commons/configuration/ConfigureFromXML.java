package com.irusist.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.List;

/**
 * Configuration config = new XMLConfiguration(resource);
 * config.getList("start-criteria.criteria");  返回start-criteria/criteria节点下的List
 * config.getString("start-criteria.criteria(0)")   返回start-criteria/criteria节点下第一个元素
 * config.getString("start-criteria.criteria(0)[@type]")    返回start-criteria/criteria节点下第一个元素的type属性
 *
 * Xerces XML parser    DOMConfiguration
 * DOM4J                DOM4JConfiguration
 * JNDI tree            JNDIConfiguration
 *
 * @author zhulixin
 */
public class ConfigureFromXML {

    public static void main(String[] args) {
        String resource = "configuration/config/global.xml";

        try {
            Configuration config = new XMLConfiguration(resource);

            // [Temperature Above -10 Celsius, Fuel tank is not empty]
            List startCriteria = config.getList("start-criteria.criteria");
            // Temperature Above -10 Celsius
            String firstCriteria = config.getString("start-criteria.criteria(0)");
            // critical
            String firstCriteriaType = config.getString("start-criteria.criteria(0)[@type]");
            // 42
            int horsepower = config.getInt("horsepower");
            System.out.println(startCriteria);
            System.out.println(firstCriteria);
            System.out.println(firstCriteriaType);
            System.out.println(horsepower);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }




    }
}
