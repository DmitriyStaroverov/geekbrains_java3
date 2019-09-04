package net.evricom.edu.java3lesson4;

/**
 * created by dima on 02.09.2019 22:48
 */
public class PriorityThread extends Thread{

    @Override
    public void run() {
        System.out.println(getName());
    }

    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread();
        PriorityThread t2 = new PriorityThread();

        System.out.println("t1 " + t1.getPriority());
        System.out.println("t2 " + t2.getPriority());

        t1.setPriority(1);
        t2.setPriority(8);

        System.out.println("t1 " + t1.getPriority());
        System.out.println("t2 " + t2.getPriority());

        t1.start();
        t2.start();
    }
}
