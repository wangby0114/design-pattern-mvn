package com.wangby.proxy;

import java.util.concurrent.TimeUnit;

public class Tank implements MoveAble {
    @Override
    public void move() {
        System.out.println("move ca ca...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
//        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

class TankTimeProxy implements MoveAble {
    MoveAble m;

    public TankTimeProxy(MoveAble m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements MoveAble {
    MoveAble m;

    public TankLogProxy(MoveAble m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("end moving...");
    }
}

interface MoveAble {
    void move();
}
