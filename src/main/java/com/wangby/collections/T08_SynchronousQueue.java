package com.wangby.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T08_SynchronousQueue {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<String>();

        new Thread(() -> {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
//            queue.put("aaa");
            queue.add("aaa");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(queue.size());
    }
}
