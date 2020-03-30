package com.wangby.collections;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedQueue<String>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票 编 号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s= tickets.poll();
                    if (s == null) break;
                    else System.out.println("销售量：" + s);
                }
            }).start();
        }
    }
}
