package net.evricom.edu.java3lesson5;

import java.util.concurrent.CountDownLatch;

/**
 * это защелка
 * created by dima on 05.09.2019 14:30
 */
public class CountDo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 10; i++) {
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(w + " - 1");
                    try {
                        Thread.sleep((int)(Math.random()*3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(w + " - 2");
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("END");
    }
}
