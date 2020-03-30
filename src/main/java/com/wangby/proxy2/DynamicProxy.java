package com.wangby.proxy2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class DynamicProxy implements MoveAble {
    @Override
    public void move() {
        System.out.println("moving kakaka...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DynamicProxy tank = new DynamicProxy();
//        MoveAble m = (MoveAble) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),
//                new Class[]{MoveAble.class},
//                new TankLogProxy(tank)
//        );
        MoveAble m = (MoveAble) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),
                new Class[]{MoveAble.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("move start");
                        Object o = method.invoke(tank, args);
                        System.out.println("stoped");
                        return o;
                    }
                }
        );
        m.move();
    }
}

class TankLogProxy implements InvocationHandler {
    DynamicProxy tank;

    public TankLogProxy(DynamicProxy tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("move start");
        Object o = method.invoke(tank, args);
        System.out.println("stoped");
        return o;
    }
}

interface MoveAble {
    void move();
}
