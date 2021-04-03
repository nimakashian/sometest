package com.adp.ouc.util.logger;

import org.apache.log4j.Logger;

import static com.adp.ouc.util.logger.SafePattern.REPLACED;
import static com.adp.ouc.util.logger.SafePattern.SAFEPATTERN;

public class SafeLogger {

    private static Logger logger;

    protected SafeLogger() {

    }

    public static SafeLogger getLogger(String name) {
        logger = Logger.getLogger(name);
        return new SafeLogger();
    }

    public static SafeLogger getLogger(Class clazz) {

        logger = Logger.getLogger(clazz);
        return new SafeLogger();
    }


    public void info(String message) {

        logger.info(message.replaceAll(SAFEPATTERN, REPLACED));
    }


    public void debug(String message) {

        logger.info(message.replaceAll(SAFEPATTERN, REPLACED));
    }

    public void debug(Object message) {
        logger.debug(message);
    }

    public void error(Object message) {
        logger.error(message);
    }

    public void error(Object message, Throwable t) {
        logger.error(message, t);
    }
}
