package com.wangby.ztest;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore s = new Semaphore(2);

        new Thread(() -> {
            try {
                s.acquire(2);
                System.out.println("--t1--running---");
                Thread.sleep(2000);
                System.out.println("--t1--running---");


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release(2);
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire(2);
                System.out.println("--t2--running--");
                Thread.sleep(2000);
                System.out.println("--t2--running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release(2);
            }
        }).start();
    }
}
