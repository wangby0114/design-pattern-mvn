package com.wangby.ztest;

import java.util.concurrent.TimeUnit;

public class Demo02 {

    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i=0; i<100; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
//        t1.run();
        t1.start();



        for (int i=0; i<100; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("main");
        }
    }
}
