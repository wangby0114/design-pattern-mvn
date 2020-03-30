package com.wangby.collections;

import java.util.concurrent.Semaphore;

public class T08_Semaphor_NOTWORK {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        //Semaphor只能保证统一时间一个线程执行，单不能保证是哪个线程执行
        Semaphore semaphore = new Semaphore(1, true);

        t1 = new Thread(() -> {
            for (char c : aI) {
                try {
                    semaphore.acquire(1);
                    System.out.println(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(1);
                }
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                try {
                    semaphore.acquire(1);
                    System.out.println(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
