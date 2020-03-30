package com.wangby.ztest;

public class RunA implements Runnable{

    private Object lock;

    public RunA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("RunA start");
                lock.wait(2000);
                System.out.println("Runa end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
