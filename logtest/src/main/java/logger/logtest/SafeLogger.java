package logger.logtest;


import org.apache.log4j.Logger;

import static logger.logtest.SafePattern.*;

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
}
