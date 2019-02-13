package com.road.LeeCode;

/**
 * @Describe 最大子序和
 * @Author Road
 * @Date 2019/2/13 14:36
 **/
public class MaximumSubarray {
	static int[] nums = { 1, 2, 3, -1, -2, -3 };

	public int maxSubarray(int[] nums) {
		int[] maxValue = new int[nums.length];
		int res = nums[0];
		maxValue[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxValue[i] = ((maxValue[i - 1] + nums[i]) > nums[i] ? (maxValue[i - 1] + nums[i]) : nums[i]);
			if (maxValue[i] > res) {
				res = maxValue[i];
			}
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		new MaximumSubarray().maxSubarray(nums);
	}
}
