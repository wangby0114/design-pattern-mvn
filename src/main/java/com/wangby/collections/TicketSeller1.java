package com.wangby.collections;

import java.util.ArrayList;
import java.util.List;

public class TicketSeller1 {

    static List<String> tickets = new ArrayList<String>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票 编 号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (TicketSeller1.class) {
                    while (tickets.size() > 0) {
//                        try {
//                            TimeUnit.MICROSECONDS.sleep(2);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }

                        System.out.println("销售了--" + tickets.remove(0));
                    }
                }

            }
            ).start();
        }
    }
}
