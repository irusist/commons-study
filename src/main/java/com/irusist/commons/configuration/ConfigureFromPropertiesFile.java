package com.irusist.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.List;

/**
 * Configuration config = new PropertiesConfiguration("configuration/config/test.properties");
 * config.getFloat(key)
 * config.getList(key)
 * config.getBoolean(key)
 *
 * @author zhulixin
 */
public class ConfigureFromPropertiesFile {

    public static void main(String[] args) {
        Configuration config = null;
        try {
            config = new PropertiesConfiguration("configuration/config/test.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        // speed=23.332
        // names=Bob,Gautam,Jarret,Stefan
        // correct=false
        float speed = config.getFloat("speed");
        List names = config.getList("names");
        boolean correct = config.getBoolean("correct");

        System.out.println(speed);
        System.out.println(names);
        System.out.println(correct);
    }
}
