package com.road.LeeCode;

/**
 * @Describe 最大子序和
 * @Author Road
 * @Date 2019/2/13 14:36
 **/
public class MaximumSubarray {
	static int[] nums = { 1, 2, 3, -1, -2, -3 };

	/**
	 * 分而治之的方法遍历
	 * 
	 * @param A
	 *          数组
	 * @param left
	 *          0
	 * @param right
	 *          最大长度
	 * @return
	 */
	public int subarray(int[] A, int left, int right) {
		if (left == right) {
			return A[left];
		}
		int mid = left + (right - left) / 2;
		// 递归调用左部分
		int leftSum = subarray(A, left, mid);
		// 递归嗲用右部分
		int rightSum = subarray(A, mid + 1, right);
		// 整个跨度部分
		int crossSum = crossSubarray(A, left, right);
		// left part is max
		if (leftSum >= rightSum && leftSum >= crossSum) {
			return leftSum;
		}
		// right part is max
		if (rightSum >= leftSum && rightSum >= crossSum) {
			return rightSum;
		}
		return crossSum;
	}

	private int crossSubarray(int[] A, int left, int right) {
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		int mid = left + (right - left) / 2;
		for (int i = mid; i >= left; i--) {
			sum = sum + A[i];
			if (leftSum < sum) {
				leftSum = sum;
			}
		}
		sum = 0;
		for (int j = mid + 1; j <= right; j++) {
			sum = sum + A[j];
			if (rightSum < sum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}

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
