package com.wangby.ztest;

import java.util.concurrent.TimeUnit;

public class ThreadA {

    static Object o1 = new Object();

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        System.out.println("b is start....");
        synchronized (o1) {
            try {
                System.out.println("Waiting for b to complete...");
                o1.wait();
                System.out.println("Completed.Now back to main thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total is :" + b.total);
    }


    static class ThreadB extends Thread {
        int total;
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o1) {
                System.out.println("ThreadB is running..");
                for (int i = 0; i < 5; i++) {
                    total += i;
                    System.out.println("total is " + total);
                }
//                o1.notify();
            }
        }
    }
}






