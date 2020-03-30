package com.wangby.ztest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo06 {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "thread--1";
                exchangeData(exchanger, data1);
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "thread--2";
                exchangeData(exchanger, data1);
            }
        });

        executor.shutdown();
    }

    public static void exchangeData(Exchanger e, String data) {
        System.out.println(Thread.currentThread().getName() + "正在交换的数据" + data);
        try {
            String data2 = (String) e.exchange(data);
            System.out.println(Thread.currentThread().getName() + "--交换后的数据：" + data2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("***************************");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("***************************");
    }
}
