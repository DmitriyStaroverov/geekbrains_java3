package net.evricom.edu.java3lesson5;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * created by dima on 04.09.2019 16:10
 */
public class Shedul {
    public static void main(String[] args) {

        Random random = new Random();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new java.util.Date() + " start!");
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new java.util.Date() + " end!");

            }
        },0,1000L, TimeUnit.MILLISECONDS);

        //executorService.shutdown();

    }
}
