package com.wangby.ztest;

import java.util.concurrent.TimeUnit;

public class Demo04 {

    public static void main(String[] args) {

         new Thread(() -> {

        }).start();
    }

    public static void print() {
        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("---runnint---");

                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
