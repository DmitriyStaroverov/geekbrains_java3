package net.evricom.edu.java3lesson5;

/**
 * created by dima on 04.09.2019 23:50
 */
public class MFU {

    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String doc, int n){
        synchronized (printLock){
            System.out.println("Начало печати: " + doc + " на " + n + " листах.");
            for (int i = 1; i < n+1; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Конец печати: " + doc + " на " + n + " листах.");
        }
    }

    public void scan(String doc, int n){
        synchronized (scanLock){
            System.out.println("\t\tНачало сканирования: " + doc + " на " + n + " листах.");
            for (int i = 1; i < n+1; i++) {
                System.out.println("\t\t" + i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\t\tКонец сканирования: " + doc + " на " + n + " листах.");
        }
    }


    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("dic 1",10);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("dic 2",5);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print("dic 3",15);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("dic 1",8);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("dic 2",2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan("dic 3",7);
            }
        }).start();
    }
}
