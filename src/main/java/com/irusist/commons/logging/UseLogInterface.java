package com.irusist.commons.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Log log = LogFactory.getLog("com.irusist.commons.loggin.UseLogInterface");获取Log实例
 * trace, debug, info, warn, error, fetal方法
 *
 * @author zhulixin
 */
public class UseLogInterface {

    public static void main(String[] args) {
        Log log = LogFactory.getLog("com.irusist.commons.loggin.UseLogInterface");

        if (log.isTraceEnabled()) {
           log.trace("This is a trace message");
        }

        if (log.isDebugEnabled()) {
            log.debug("This is a debug message");
        }

        log.info("This is an informational message");

        log.warn("This is a warning");

        log.error("This is an error");

        log.fatal("This is fetal");
    }
}
