package net.evricom.edu.java3lesson6.ru.gb;

import org.apache.log4j.Logger;

/**
 * created by dima on 13.09.2019 13:11
 */
public class MainLog4jClass {

    private static Logger logger = Logger.getLogger(MainLog4jClass.class);

    public static void main(String[] args) {

        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }
}
