package net.evricom.edu.java3lesson4;

/**
 * created by dima on 02.09.2019 16:44
 */
public class StopThread {

    private static boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        //break;
//                        e.printStackTrace();
//                    }
                    System.out.println("A");
                }
            }
        });
        //t1.setDaemon(true);
        t1.start();

        Thread.sleep(1000);
        System.out.println("END");
        t1.interrupt();
        //t1.stop();
        //isRunning = false;

    }
}
