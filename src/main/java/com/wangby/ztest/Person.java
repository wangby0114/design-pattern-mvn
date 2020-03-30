package com.wangby.ztest;

public class Person {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("--finalize--");
    }
}
