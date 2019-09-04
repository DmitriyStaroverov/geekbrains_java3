package net.evricom.edu.java3lesson4;

/**
 * created by dima on 02.09.2019 0:52
 */
public class Event {
    public static void main(String[] args) {

        Object стул1 = new Object();
        Object стул2 = new Object();

        Thread чел1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел1 подошел к стулу1");
                synchronized (стул1) {
                    System.out.println("Чел1 сел на стул1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел1 встал со стула1.");
                }
            }
        });

        Thread чел2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел2 подошел к стулу1");
                synchronized (стул1) {
                    System.out.println("Чел2 сел на стул1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел2 встал со стула1.");
                }
            }
        });

        Thread чел3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел3 подошел к стулу2");
                synchronized (стул2) {
                    System.out.println("Чел3 сел на стул2");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел3 встал со стула2.");
                }
            }
        });
        чел1.start();
        чел2.start();
        чел3.start();

    }
}

class TestRun {

    private static StringBuilder n = new StringBuilder("1");

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("X1 " + i);
                        n.append("1");//n++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("T1 " + (System.currentTimeMillis() - t));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("X2 " + i);
                        n.append("1");//n++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("T2 " + (System.currentTimeMillis() - t));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (n) {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("X3 " + i);
                        n.append("1");//n++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("T3 " + (System.currentTimeMillis() - t));
            }
        }).start();


    }
}