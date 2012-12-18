package com.irusist.commons.logging;

/**
 * 1.查看 org.apache.commons.logging.Log 的系统属性(system property)，如果设置了，则用指定的值
 * System.setProperty("org.apache.commons.logging.Log", String)
 * 2.查看classpath当中是否有Log4J，如果有，则用Log4JLogger
 * 3.查看JDK1.4 logging framework,如果存在，则用JDK14Logger
 * 4.如果都不存在，在用SimpleLog
 *
 * @author zhulixin
 */
public class SpecifyLoggingImplementation {

    public static void main(String[] args) {

        System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.Log4JLogger");
    }
}
