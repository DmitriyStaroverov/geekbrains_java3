package net.evricom.edu.java3lesson4;

/**
 * created by dima on 02.09.2019 8:21
 */
public class TestDeadlock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    static class DeadThreadLockOne extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadThreadLockOne держит lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadThreadLockOne ждет lock2");
                synchronized (lock2) {
                    System.out.println("DeadThreadLockOne держит lock1 и lock2");
                }
            }
        }
    }

    static class DeadThreadLockTwo extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadThreadLockTwo держит lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadThreadLockTwo ждет lock1");
                synchronized (lock1) {
                    System.out.println("DeadThreadLockOne держит lock1 и lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadThreadLockOne deadThreadLockOne = new DeadThreadLockOne();
        deadThreadLockOne.start();

        DeadThreadLockTwo deadThreadLockTwo = new DeadThreadLockTwo();
        deadThreadLockTwo.start();

    }

}
