package com.wangby.ztest;

public class Demo07 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("11111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println("------");

        System.out.println(Integer.MAX_VALUE);
    }

}
