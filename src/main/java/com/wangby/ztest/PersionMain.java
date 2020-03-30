package com.wangby.ztest;

import java.util.UUID;

public class PersionMain {
    public static void main(String[] args) {
        Person person = new Person();
        person = null;

        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID());
        }


    }
}
