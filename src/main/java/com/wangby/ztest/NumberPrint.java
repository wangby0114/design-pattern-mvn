package com.wangby.ztest;

public class NumberPrint implements Runnable {

    private int number;
    public byte res[];
    public static int count=5;

    public NumberPrint(int number, byte[] res) {
        this.number = number;
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            while (count-- >0) {
                try {
//                    res.notify();
                    System.out.println(" " + number);

                    res.wait(3);
                    System.out.println("------线程" +Thread.currentThread().getName() + "获得锁，wait()后的代码继续运行："+number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
    }

    public static void main(String[] args) {
        final byte res[] = {0};
        new Thread(new NumberPrint(1, res), "1").start();
        new Thread(new NumberPrint(2, res), "2").start();

    }
}
