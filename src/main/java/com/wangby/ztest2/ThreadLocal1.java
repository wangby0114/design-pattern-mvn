package com.wangby.ztest2;

import java.util.concurrent.TimeUnit;

public class ThreadLocal1 {

    static volatile Person person = new Person();

    public static void main(String[] args) {

        System.out.println("--start---");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(person.getName());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            person.setName("www");
        }).start();


    }
}
