package com.wangby.ztest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {

    private static Lock lock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();


    public static void read(Lock lock) {

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("Read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock) {

        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Runnable read = () -> ReentrantLockTest.read(readLock);
        Runnable wirte = () -> ReentrantLockTest.write(writeLock);

        for (int j = 0; j < 2; j++) {
            new Thread(wirte).start();
        }

        for (int i = 0; i < 18; i++) {
            new Thread(read).start();;
        }
    }


}
