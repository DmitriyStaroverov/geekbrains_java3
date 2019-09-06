package net.evricom.edu.java3lesson5;

import java.util.concurrent.*;

/**
 * created by dima on 04.09.2019 14:58
 */
public class ExecutorServ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("new Thread");
                Thread t = new Thread(r);
                return t;
            }
        });

        for (int i = 1; i < 7; i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            });
        }

        Future<String> out = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return ("Java " + Thread.currentThread().getName());
            }
        });
        System.out.println(out.get());

        //pool.awaitTermination(3000, TimeUnit.MILLISECONDS);

        //pool.shutdownNow();
        pool.shutdown();
    }
}
