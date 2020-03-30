package com.wangby.singleton;

/**
 * 饿汗式
 */
public class Mgr01 {

    private Mgr01() {
    }

    private static final Mgr01 INSTANCE = new Mgr01();

    public static Mgr01 getSingleton() {
        return INSTANCE;
    }

    public static void main(String[] args) {

        Mgr01 mgr01_1 = Mgr01.getSingleton();
        Mgr01 mgr01_2 = Mgr01.getSingleton();

        System.out.println(mgr01_1 == mgr01_2);


    }
}
