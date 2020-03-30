package com.wangby.strategy;

import java.util.Arrays;

public class Cat2 implements Comparable<Cat2> {
    private int weight;
    private int height;

    public Cat2(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat2{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Cat2 o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Cat2 cat_0 = new Cat2(3, 3);
        Cat2 cat_1 = new Cat2(8, 8);
        Cat2 cat_2 = new Cat2(5, 5);
        Cat2 cat_3 = new Cat2(4, 4);

        Cat2[] c = {cat_0, cat_1, cat_2, cat_3};
        System.out.println(Arrays.toString(c));
        Sorter.cat2Sort2(c);
        System.out.println(Arrays.toString(c));

    }
}
