package cn.jc.datastructure.sort;

import cn.jc.util.Util;

public class BubbleSort {

    /**
     * 最差的冒泡排序，（较笨的写法）
     * n*(n-1)次比较，0-n*(n-1)次交换
     * 需要一个额外变量的空间
     * @param arr
     */
    public void sort0(int[] arr) {
        int compareTimes = 0;
        int swapTimes = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                compareTimes++;
                if (arr[j] > arr[j + 1]) {
                    Util.swap(arr, j, j + 1);
                    swapTimes++;
                }
            }
        }
        System.out.println("数组长度:" + arr.length + " 比较次数:" + compareTimes + " 交换次数:" + swapTimes);
    }

    /**
     * 稍优化一点的冒泡排序，（正常的写法）
     * n*(n-1)/2次比较，（0-n*(n-1)/2）次交换
     * 需要一个额外变量的空间
     * @param arr
     */
    public void sort(int[] arr) {
        int compareTimes = 0;
        int swapTimes = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                compareTimes++;
                if (arr[j] > arr[j + 1]) {
                    swapTimes++;
                    Util.swap(arr, j, j + 1);
                }
            }
        }
        System.out.println("数组长度:" + arr.length + " 比较次数:" + compareTimes + " 交换次数:" + swapTimes);
    }

    public static void main(String[] args) {
        int[] aaa;
        aaa = new int[]{1, 17, 6, 9, 2, 4, 100, 38, 94, 29, 46, 3, 57, 65, 19, 5};
        new BubbleSort().sort(aaa);
        System.out.println(Util.toString(aaa));
        aaa = new int[]{1, 17, 6, 9, 2, 4, 100, 38, 94, 29, 46, 3, 57, 65, 19, 5};
        new BubbleSort().sort0(aaa);
        System.out.println(Util.toString(aaa));
    }
}
