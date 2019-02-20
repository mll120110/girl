package com.road.LeeCode.n.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe 整数数组挑选4个数，等于target
 * @Author Road
 * @Date 2019/2/19 17:33
 **/
public class FourSum {
    static int[] nums = {1, 0, -1, 0, -2, 2};

    /**
     * 思路：遍历排序后的int数组，先遍历排序后的第一个元素，该元素与（target - z）是否相等，寻找（target - z）是否等于a+b+c
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }
        // 数组排序
        Arrays.sort(nums);

        // 获取数组中，排序之后最大的数
        int max = nums[len - 1];
        // 排除数组中最大数无效
        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }

        // 数组遍历
        for (int i = 0; i < len; i++) {
            int z = nums[i];
            // 避免重复数字
            if (i > 0 && z == nums[i - 1]) {
                continue;
            }
            // z is too small
            if (z + 3 * max < target) {
                continue;
            }
            // z is too large
            if (4 * z > target) {
                break;
            }
            // z is the boundary
            if (4 * z == target) {
                if (i + 3 < len && nums[i + 3] == z) {
                    res.add(Arrays.asList(z, z, z, z));
                    break;
                }
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /**
     *
     * @param nums
     *            整数数组
     * @param target
     *            目标值
     * @param low
     *            左边元素号
     * @param high
     *            右边最大元素号
     * @param fourSumList
     *            放回res数组集合
     * @param zl
     *            4个数中，当前循环元素
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
        int zl) {
        if (low + 1 >= high) {
            return;
        }

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target) {
            return;
        }

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) {
                continue;
            }
            if (z + 2 * max < target) {
                continue;
            }
            if (3 * z > target) {
                break;
            }
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z) {
                    fourSumList.add(Arrays.asList(zl, z, z, z));
                    break;
                }
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, zl, z);
        }
    }

    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
        int z1, int z2) {
        if (low >= high) {
            return;
        }
        if (2 * nums[low] > target || 2 * nums[high] < target) {
            return;
        }
        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[j];
                while (++i < j && x == nums[i]) {
                    ;
                }
                x = nums[j];
                while (i < --j && x == nums[j]) {
                    ;
                }
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Math.abs(14);
        new FourSum().fourSum(nums, 0);
    }
}
