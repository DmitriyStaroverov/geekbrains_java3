package net.evricom.edu.java3lesson5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * created by dima on 05.09.2019 22:18
 */
public class Reentrant {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println(1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
                reentrantLock.unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println(3);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(4);
                reentrantLock.unlock();
            }
        }).start();
    }
}
