package com.road.LeeCode;

/**
 * 快速排序
 * 
 * 1.一开始选定数组的最后一个元素5作为基准值，也就是最终排序结果应该是以5为界限划分为左右两边。
 *
 * 2.从左边开始，寻找比5大的值，然后与5进行调换(因为如果比5小的值本来就应该排在5前面，比5大的值调换之后就去到了5的后面)，一路过来找到了7，将7与5调换，结束此次遍历。
 *
 * 3.从右边开始，由于7已经是上一轮排好序的便不再动它，从10开始，一路向左遍历，寻找比5小的值，然后与5进行调换(因为如果比5大的值本来就应该排在5后面，比5小的值调换之后就去到了5的后前面)，一路过来找到了4，将4与5调换，结束此次遍历。
 *
 * 4.从左边开始，由于3和4都是前两轮已经排好序的便不再动它，从2开始，一路向右遍历，寻找比5大的值，然后与5进行调换（道理同步骤2），一路过来找到了9，将9与5调换，结束此次遍历。
 *
 * 5.从右边开始，由于排在9后面的那几个数字都是上几轮排好序的便不再动它，从1开始，一路向右遍历，寻找比5小的值，然后与5进行调换(道理同步骤3)，一下子就找到了1，将1与5调换，结束此次遍历。
 *
 * 6.这个时候，发现5的左右两边都是排好序了的，所以结束此轮排序，5的左右两边抽出来各自进行下一轮的排序，规则同上，直到无法再拆分下去，即完成了整体的快速排序。
 * 
 */
public class QucikSort {
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[] {2, 7, 4, 5, 10, 1, 9, 3, 8, 6};
        int[] b = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] c = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] d = new int[] {1, 10, 2, 9, 3, 2, 4, 7, 5, 6};

        sort(a, 0, a.length - 1);

        System.out.println("排序后的结果：");
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param start
     * @param end
     */
    public static void sort(int[] a, int start, int end) {
        if (start > end) {
            return;
        } else {
            // 获取基准位
            int divide = divide(a, start, end);
            sort(a, start, divide - 1);
            sort(a, divide + 1, end);
        }
    }

    /**
     * 获取基准位
     * 
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int divide(int[] a, int start, int end) {
        int base = a[end];
        while (start < end) {
            while (start < end && a[start] <= base) {
                start++;
                if (start < end) {
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                    end--;
                }
                for (int x : a) {
                    System.out.print(x + " ");
                }
                System.out.println(";");
            }
            while (start < end && a[start] >= base) {
                end--;
                if (start < end) {
                    int temp = a[start];
                    a[start] = a[end];
                    a[end] = temp;
                    start++;
                }
            }
        }
        return end;
    }
}
