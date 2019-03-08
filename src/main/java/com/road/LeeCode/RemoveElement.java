package com.road.LeeCode;

/**
 * @Describe 移除元素
 * @Author Road
 * @Date 2019/2/12 11:43
 **/
public class RemoveElement {
    static int[] nums = {1, 4, 2, 3};
    static int val = 2;

    /**
     * 移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
            System.out.println(nums);
        }
        System.out.println(nums);
        return n;
    }

    public int removerEle(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        // 数组存储下标
        int j = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 若不等于target，存入数组
            if (nums[i] != target) {
                nums[j++] = nums[i];
                System.out.println(nums[j++]);
            }
        }
		System.out.println(j);
        return j;
    }

    public static void main(String[] args) {
        // removeElement(nums, val);
        new RemoveElement().removerEle(nums, 3);
    }
}
