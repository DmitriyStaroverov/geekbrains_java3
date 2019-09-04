package net.evricom.edu.java3lesson4;

/**
 * created by dima on 01.09.2019 23:41
 */
public class TestT1 {
    public synchronized void method() {
        System.out.println("M1");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2");
    }

    Object lock = new Object();

    public void method2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " Параллельно!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " Последовательно!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Start {
    public static void main(String[] args) {
        TestT1 t1 = new TestT1();
        TestT1 t2 = new TestT1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.method2();
            }
        }).start();
    }
}