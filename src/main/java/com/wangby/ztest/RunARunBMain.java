package com.wangby.ztest;

public class RunARunBMain {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread threadA = new Thread(new RunA(lock));
        threadA.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(new RunB(lock));
        threadB.start();
    }
}
