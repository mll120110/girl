package com.road.LeeCode.n.sum;

import java.util.Arrays;

/**
 * @Describe
 * @Author Road
 * @Date 2019/2/20 13:41
 **/
public class ThreeSumClose {
    static int[] nums = {-1, 2, 1, -4};

    public int threeSumClose(int[] nums, int target) {
        int len = nums.length;
        if (len < 1 || nums == null) {
            return 0;
        }
        // 为什么要找这样的数，作比较呢
        // int result = nums[0] + nums[1] + nums[2];
        int result = nums[0] + nums[1] + nums[len - 1];

        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new ThreeSumClose().threeSumClose(nums, 1);
    }
}
