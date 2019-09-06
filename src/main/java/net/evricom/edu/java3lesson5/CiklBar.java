package net.evricom.edu.java3lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * created by dima on 05.09.2019 17:15
 */
public class CiklBar {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2);

        for (int i = 0; i < 10; i++) {
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(w + " - 1");
                    try {
                        Thread.sleep(1000);
                       cb.await();
                        System.out.println(w + " - 2");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
