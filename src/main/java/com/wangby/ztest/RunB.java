package com.wangby.ztest;

public class RunB implements Runnable {
    private Object lock;

    public RunB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("RunB start");
            while (true) {

            }
        }
    }
}
