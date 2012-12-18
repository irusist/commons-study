package com.irusist.commons.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j2查找文件顺序：
 * 1. 查看log4j.configurationFile系统属性(system property)，如果设置了，则用相应的ConfigurationFactory
 * 2. 如果第一个未设置，JSON ConfigurationFactory在classpath中查找log4j2-test.json或者log4j2-test.jsn文件
 * 3. 如果第2步未找到，XML ConfigurationFactory在classpath中查找 log4j2-test.xml文件
 * 4. 如果第3步未找到，JSON ConfigurationFactory在classpath中查找log4j2.json或log4j2.jsn文件
 * 5. 如果第4步未找到，XML ConfigurationFactory在classpath中查找log4j2.xml文件
 * 6. 以上的所有条件都未满足，则会使用DefaultConfiguration，它会输出到控制台
 * (ConsoleAppender, PatternLayout= "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"
 * level=Level.ERROR)
 *
 * @author zhulixin
 */
public class ConfigureWithXML {

    private static Logger logger = LogManager.getLogger(ConfigureWithXML.class.getName());

    public static void main(String[] args) {
       logger.trace("Entering application");
       Bar bar = new Bar();
       if (!bar.doIt()) {
           logger.error("Didn't do it");
       }

       logger.trace("Exiting application");

    }

    static class Bar {
        private static Logger logger = LogManager.getLogger(Bar.class.getName());

        public boolean doIt() {
            logger.entry();
            logger.error("Did it again!");
            return logger.exit(false);
        }
    }
}

