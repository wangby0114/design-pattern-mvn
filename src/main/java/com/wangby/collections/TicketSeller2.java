package com.wangby.collections;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TicketSeller2 {

    static Vector<String> tickets = new Vector<String>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票 编 号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (TicketSeller2.class) {
                    while (tickets.size() > 0) {
                        try {
                            TimeUnit.MICROSECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了--" + tickets.remove(0));
                    }
                }
            }
            ).start();
        }
    }
}
