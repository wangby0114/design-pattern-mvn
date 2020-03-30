package com.wangby.ztest2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {

    final private LinkedList<T> lists = new LinkedList<T>();
    final private int MAX = 10;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            if (lists.size() == MAX) {
                producer.await();
            }
            lists.add(t);
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            if (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<String>();
        for (int i = 0; i < 2; i++) {
            new Thread(() ->  {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }


//        try {
//            Thread.sleep(1000*2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }
    }
}
