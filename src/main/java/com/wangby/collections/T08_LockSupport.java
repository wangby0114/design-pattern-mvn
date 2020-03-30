package com.wangby.collections;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T08_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {
            for (char c : aI) {
                System.out.println(c);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : aC) {
                System.out.println(c);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
