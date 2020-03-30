package com.wangby.collections;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T08_Reentrantlock {

    static Thread t1 =null, t2 = null;
    static Lock lock = new ReentrantLock();
//    static Condition condition = lock.newCondition();

    static Condition t1C = lock.newCondition();
    static Condition t2C = lock.newCondition();


    public static void main(String[] args) {

        char[] aI = "12345678".toCharArray();
        char[] aC = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.println(c);
//                    condition.signal();
//                    condition.await();
                    t2C.signal();
                    t1C.await();
                }
//                condition.signal();

                t2C.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");


        t2 = new Thread(() -> {
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.println(c);
//                    condition.signal();
//                    condition.await();

                    t1C.signal();
                    t2C.await();
                }
//                condition.signal();

                t1C.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        t1.start();
        t2.start();

    }
}
