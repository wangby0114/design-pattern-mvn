package com.wangby.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T08_BlockingQueue {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue<String>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                System.out.println(c);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : aC) {
                System.out.println(c);
                try {
                    q2.put("ok");
                    q1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
