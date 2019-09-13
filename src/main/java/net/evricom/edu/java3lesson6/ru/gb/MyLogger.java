package net.evricom.edu.java3lesson6.ru.gb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * created by dima on 13.09.2019 9:31
 */
public class MyLogger {
    private static final Logger logger = Logger.getLogger(net.evricom.edu.java3lesson6.ru.gb.MyLogger.class.getName());

    public static void main(String[] args) throws IOException {
        System.out.println(logger.getParent().getName() + " parent");
        System.out.println(logger.getName() + " this");

        LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));

        logger.log(Level.SEVERE,"Java");
        logger.log(Level.INFO,"Info log");
        logger.log(Level.CONFIG,"config log");
        logger.log(Level.FINE,"config fine");
    }
}
