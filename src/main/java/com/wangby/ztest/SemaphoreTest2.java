package com.wangby.ztest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final long num = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire(3);
                    System.out.println("Accessing: " + num);
                    TimeUnit.SECONDS.sleep(1);
                    semaphore.release(3);
                    System.out.println("Reless..." + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
