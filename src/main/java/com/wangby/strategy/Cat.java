package com.wangby.strategy;

import java.util.Arrays;

public class Cat {
    private int weight;
    private int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    public int compare(Cat c) {
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        Cat cat_0 = new Cat(3, 3);
        Cat cat_1 = new Cat(8, 8);
        Cat cat_2 = new Cat(5, 5);
        Cat cat_3 = new Cat(4, 4);

        Cat[] catArr = {cat_0, cat_1, cat_2, cat_3};
        System.out.println(Arrays.toString(catArr));
        Sorter.catSort(catArr);
        System.out.println(Arrays.toString(catArr));
    }
}
