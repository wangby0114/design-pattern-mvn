package com.wangby.collections;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class T08_TransferQueue {

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        TransferQueue queue = new LinkedTransferQueue();

        new Thread(() -> {
            for (char c : aI) {
                try {
                    System.out.println(queue.take());
                    queue.transfer(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (char c : aC) {
                try {
                    queue.transfer(c);
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
