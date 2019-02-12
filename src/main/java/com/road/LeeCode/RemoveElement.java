package com.road.LeeCode;

/**
 * @Describe 移除元素
 * @Author Road
 * @Date 2019/2/12 11:43
 **/
public class RemoveElement {
	static int[] nums = { 1, 2, 2, 4 };
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

	public static void main(String[] args) {
		removeElement(nums, val);
	}
}
