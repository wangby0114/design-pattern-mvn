package com.wangby.strategy;

public class Sorter {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            swap(arr, i, minPos);
        }
    }
    public static void swap(int[] arr, int i, int minPos) {
        int temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }

    public static void catSort(Cat[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < c.length; j++) {
                minPos = c[j].compare(c[minPos]) == -1 ? j : minPos;
            }

            catSwap(c, i, minPos);
        }
    }

    public static void catSwap(Cat[] c, int i, int minPos) {
        Cat temp = c[i];
        c[i] = c[minPos];
        c[minPos] = temp;
    }

    public static void cat2Sort2(Comparable[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < c.length; j++) {
                minPos = c[j].compareTo(c[minPos]) == -1 ? j : minPos;
            }

            catSwap2(c, i, minPos);
        }
    }
    public static void catSwap2(Comparable[] c, int i, int minPos) {
        Comparable temp = c[i];
        c[i] = c[minPos];
        c[minPos] = temp;
    }

}
