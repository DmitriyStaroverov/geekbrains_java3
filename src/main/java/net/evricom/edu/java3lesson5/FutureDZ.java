package net.evricom.edu.java3lesson5;

import java.util.concurrent.*;

/**
 * created by dima on 13.09.2019 0:08
 */
public class FutureDZ {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int[] source = {1, 2, 3, 4};
        int[] res1 = new int[2];
        int[] res2 = new int[2];

        System.arraycopy(source, 0, res1, 0, res1.length);
        System.arraycopy(source, res1.length, res2, 0, res2.length);

        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res1.length; i++) {
                    res += res1[i];
                }
                return res;
            }
        };
        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res2.length; i++) {
                    res += res2[i];
                }
                return res;
            }
        };

        Future<Integer> future1 = executorService.submit(callable1);
        Future<Integer> future2 = executorService.submit(callable2);

        System.out.println(future1.get() + " " + future2.get());
        executorService.shutdown();
    }
}
