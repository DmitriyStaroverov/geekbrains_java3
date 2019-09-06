package net.evricom.edu.java3lesson5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by dima on 05.09.2019 23:01
 */
public class Atomic {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ai.incrementAndGet();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ai.decrementAndGet();
                }
            }
        }).start();

        System.out.println(ai);

    }
}
