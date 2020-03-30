package com.wangby.strategy;

import java.util.Arrays;

public class DogComparatorMain {

    public static void main(String[] args) {
        Dog[] dogs = {new Dog(3), new Dog(2), new Dog(0), new Dog(6)};

        SorterStrategy<Dog> sort = new SorterStrategy<Dog>();
        System.out.println(Arrays.toString(dogs));
        sort.sort(dogs, new DogComparator());
        System.out.println(Arrays.toString(dogs));
    }
}
