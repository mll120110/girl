package com.road.LeeCode;

import java.util.*;

/**
 * @Describe 三数之和
 * @Author Road
 * @Date 2019/2/14 18:12
 **/
public class ThreeSum {
    static int[] nums = {-1, 0, 1, 2, -1, -4};

    /**
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 将数组排序,使用有序数列的好处是，在移动指针时，值相等的数可以跳过，省去去重部分
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
            while (left < right) {
                System.out.println(Arrays.asList(nums[i], nums[left++], nums[right--]));
                // 如果获取到a+b+c=0,输出并判断
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    // 遇见有相同的数组跳过
                    while (right > left && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                // 如果nums[left] + nums[right] > sum
                else if (nums[left] + nums[right] > sum) {
                    right--;
                }
                // 如果nums[left] + nums[right] < sum
                else {
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumTwo(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // int sum = sum - nums[i]
            int sum = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (j == i)
                    continue;
                if (set.contains(nums[j])) {
                    List<Integer> lst = Arrays.asList(nums[i], nums[j], (-nums[i] - nums[j]));
                    Collections.sort(lst);
                    if (ansList.contains(lst))
                        continue;
                    ansList.add(lst);
                    continue;
                }
                set.add(sum - nums[j]);
            }

        }
        return ansList;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(nums);
    }
}
