package com.wangby.collections;

import java.util.concurrent.CountDownLatch;

public class T09_WaitNotify {

    static Thread t1 = null, t2 = null;
    static final Object object = new Object();

//    static volatile boolean t2Started = false;

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
//                while (!t2Started) {
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

//                try {
//                    object.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                for (char c : aI) {
                    try {
                        System.out.println(c);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        }, "t1");

        t2 = new Thread(() -> {
            latch.countDown();
            synchronized (object) {
//                t2Started = true;

//                object.notify();

                for (char c : aC) {
                    try {
                        System.out.println(c);
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
        });
        t1.start();
        t2.start();
    }
}
