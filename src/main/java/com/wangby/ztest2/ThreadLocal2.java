package com.wangby.ztest2;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {

    static ThreadLocal<Person> p = new ThreadLocal<Person>();
    static {
        p.set(new Person());
    }

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(p.get().getName());
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.get().setName("111");
        }).start();
    }
}
