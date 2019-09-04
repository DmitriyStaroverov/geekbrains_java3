package net.evricom.edu.java3lesson4;

/**
 * created by dima on 03.09.2019 0:22
 */
public class DZ4 {

    private static final int NUM = 20;

    private volatile char ch = 'A';

    public static void main(String[] args) {
        DZ4 dz4 = new DZ4();
        Thread ta = new Thread(() -> {
            dz4.printA();
        });
        Thread tb = new Thread(() -> {
            dz4.printB();
        });
        Thread tc = new Thread(() -> {
            dz4.printC();
        });
        ta.start();
        tb.start();
        tc.start();
    }

    private synchronized void printC() {
        for (int i = 0; i < NUM; i++) {
            try {
                while (ch != 'C') {
                    wait();
                }
                System.out.print("C");
                ch = 'A';
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printB() {
        for (int i = 0; i < NUM; i++) {
            try {
                while (ch != 'B') {
                    wait();
                }
                System.out.print("B");
                ch = 'C';
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printA() {
        for (int i = 0; i < NUM; i++) {
            try {
                while (ch != 'A') {
                    wait();
                }
                System.out.print("A");
                ch = 'B';
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
