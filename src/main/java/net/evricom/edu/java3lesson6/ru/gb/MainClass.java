package net.evricom.edu.java3lesson6.ru.gb;

import java.io.IOException;
import java.util.logging.*;

/**
 * created by dima on 13.09.2019 8:25
 */
public class MainClass {
    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);


        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + " " + record.getMessage() + " " + record.getMillis() + "\n" ;
            }
        });

        logger.getHandlers()[0].setFilter(record -> record.getMessage().startsWith("Java"));

        Handler handler = new FileHandler("mylog.log");
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        logger.log(Level.SEVERE,"Java");
        logger.log(Level.INFO,"Info log");
        logger.log(Level.CONFIG,"config log");
        logger.log(Level.FINE,"config fine");


        //System.out.println(Arrays.toString(logger.getHandlers()));

//        Level.OFF;
//        Level.SEVERE;
//        Level.WARNING;
//        Level.INFO;
//        Level.CONFIG;
//        Level.FINE;
//        Level.FINER;
//        Level.FINEST;
//        Level.ALL;


    }
}
