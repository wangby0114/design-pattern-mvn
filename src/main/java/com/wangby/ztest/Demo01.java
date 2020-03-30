package com.wangby.ztest;

public class Demo01 {

    public static void printValue(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) throws InterruptedException {
//        List<String> al = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
//
//        String[] arr = al.toArray(new String[al.size()]);
////
////        for (String a : al) {
////            Demo01.printValue(a);
////        }
////
////        System.out.println();
////
////        al.forEach(x -> {Demo01.printValue(x);});
//
//        List<Integer> list = Arrays.asList(9, 3, 3);
//
//        list = list.stream().distinct().collect(Collectors.toList());
//        list.forEach(System.out::println);
//
//        System.out.println();
//
//        //distinct()函数，是去重复函数
//        list = list.stream().distinct().map(i -> i * i).collect(Collectors.toList());
//        //打印输出list
//        list.forEach(System.out::println);


        int[] arr2 = {2, 4, 6, 3, 1, 56, 79, 2, 3, 45, 6, 7, 39};

        Demo01 demo01 = new Demo01();
        //demo01.sort(arr2);
        demo01.bubbleSort(arr2);
    }


    //选择排序
    public void sort(int[] arr) throws InterruptedException {

        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;

                Thread.sleep(1);
            }
            exchange(arr, i, minPos);
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if (arr[j] < arr[i]) {
                    exchange(arr, i, j);
                }
            }
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    void exchange(int[] arr, int i, int minPos) {
        int temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }
}
