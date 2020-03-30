package com.wangby.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2,1,5,8,3,0};
        System.out.println(Arrays.toString(arr));
        Sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
