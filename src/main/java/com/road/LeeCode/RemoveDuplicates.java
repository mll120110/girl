package com.road.LeeCode;

/**
 * @Describe 有序数组中移除重复元素
 * @Author Road
 * @Date 2019/2/20 14:51
 **/
public class RemoveDuplicates {
    static int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 若num[i]的值（从数组左边遍历到右边），遍历了几个元素之后，当前遍历的元素值与最初的nums[j]的值不一样，赋值数组
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(nums);
    }
}
