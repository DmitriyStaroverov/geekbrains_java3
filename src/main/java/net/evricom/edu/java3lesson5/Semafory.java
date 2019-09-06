package net.evricom.edu.java3lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * created by dima on 05.09.2019 12:57
 */
public class Semafory {



    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Semaphore smp = new Semaphore(4,true);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        smp.acquire();
                        System.out.println(1);
                        Thread.sleep(1000);
                        smp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(2);
                }
            });
        }
        service.shutdown();
    }
}
