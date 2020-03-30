package com.wangby.strategy;

import java.util.Comparator;

public class SorterStrategy<T> {

    public  void sort(T[] t, Comparator<T> comparator) {
        for (int i = 0; i < t.length - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < t.length; j++) {
//                minPos = comparator.compare(t[minPos], t[j]) == -1 ? minPos : j;
                minPos = comparator.compare(t[j], t[minPos]) == -1 ? j : minPos;
            }
            swap(t, i, minPos);
        }
    }

    public void swap(T[] t, int i, int minPos) {
        T temp = t[i];
        t[i] = t[minPos];
        t[minPos] = temp;
    }
}
