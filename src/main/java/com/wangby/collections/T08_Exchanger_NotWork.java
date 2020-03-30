package com.wangby.collections;

import java.util.concurrent.Exchanger;

public class T08_Exchanger_NotWork {

    public static void main(String[] args) {
        final Exchanger exchanger = new Exchanger();
        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                System.out.println(c);
                try {
                    exchanger.exchange("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c : aC) {
                try {
                    exchanger.exchange("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(c);
            }
        }).start();

    }
}
