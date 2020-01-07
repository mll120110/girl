package com.road.LeeCode;

public class HeadSort {

    public static void main(String[] args) {
        int[] a = new int[] {2, 7, 4, 5, 10, 1, 9, 3, 8, 6};
        mergeSort(a, a.length);
    }

    public static void mergeSort(int[] A, int n) {
        mergeSortC(A, 0, n - 1);
    }

    /**
     * 合并递归函数
     * 
     * @param A
     *            数组
     * @param p
     *            起始值
     * @param r
     *            终止值
     */
    public static void mergeSortC(int[] A, int p, int r) {
        // 递归终止条件
        if (p >= r) {
            return;
        }
        // 取P，r中间值
        int q = (p + r) / 2;

        // 分治递归
        mergeSortC(A, p, q);
        mergeSortC(A, q + 1, r);

        // 合并
    }
}
