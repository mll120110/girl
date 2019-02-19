package com.road.LeeCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Describe 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 给定 nums = [2, 7, 11, 15], target = 9 因为
 *           nums[0] + nums[1] = 2 + 7 = 9,所以返回 [0, 1]
 * @Author Road
 * @Date 2019/2/13 16:54
 **/
public class TwoSum {
    static int[] nums = {2, 5, 5, 11};
    static int target = 10;

    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumFirst(int[] nums, int target) {
        boolean isBreak = false;
        int[] resArray = new int[2];
        if (nums.length < 1) {
            return resArray;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    resArray[0] = i;
                    resArray[1] = j;
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                break;
            }
        }
        System.out.println("left:" + resArray[0] + ",right:" + resArray[1]);
        return resArray;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] resArray = new int[2];
        // 将数组排序
        Arrays.sort(nums);
        // pushToMap
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], nums[i]);
        }
        // 遍历Map寻找
        for (int j = 0; j < nums.length; j++) {
            if (hashMap.containsKey(target - nums[j])) {
                resArray[0] = nums[j];
                resArray[1] = hashMap.get(target - nums[j]);
                System.out.println("left:" + resArray[0] + ",right:" + resArray[1]);
            }
        }
        return resArray;
    }

    public static void main(String[] args) {
        // new TwoSum().twoSumFirst(nums, target);
        new TwoSum().twoSum(nums, target);
    }
}
