package cn.jc.datastructure.search;

public class ErfenSearchB {

    /**
     * 二分查找 前提有序 找到最后一个
     * @param a
     * @param key
     * @return
     */
    public int findA_end(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        int j = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (key < a[mid]) {
                end = mid - 1;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                //找第一个从前往后缩进
                start = mid;
            }
        }
        if (a[end] != key) {
            return -1;
        } else {
            return end;
        }
    }

    /**
     * 二分查找 前提有序 找到第一个
     * @param a
     * @param key
     * @return
     */
    private int findA_start(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            //加1向右靠？
            int mid = (start + end + 1) / 2;
            if (key < a[mid]) {
                end = mid - 1;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                //找第一个从后往前缩进
                end = mid;
            }
        }
        if (a[start] != key) {
            return -1;
        } else {
            return start;
        }
    }

    /**
     * 二分查找 前提有序不重复 循环
     * @param a
     * @param key
     * @return
     */
    private int findA_xunhuan(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < a[mid]) {
                end = mid - 1;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找 前提有序不重复 递归
     * @param a
     * @param key
     * @param start
     * @param end
     * @return
     */
    private int findA_digui(int[] a, int key, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (key > a[mid]) {
                return findA_digui(a, key, mid + 1, end);
            } else if (key < a[mid]) {
                return findA_digui(a, key, start, mid - 1);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }


}
