package com.road.LeeCode;

/**
 * @Describe 搜索插入位置
 * @Author Road
 * @Date 2019/2/13 9:43
 **/
public class SearchInsertPosition {
	static int[] nums = { 1, 3, 5, 6 };
	static int target = 2;

	/**
	 * 暴力遍历
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= target && target <= nums[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	/**
	 * 折半搜索
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsertHalfInterval(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		if (nums.length == 0) {
			return 0;
		}
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// 目标值在不在当前停的位置的前边还是后边
		if (target > nums[low]) {
			return low + 1;
		}
		// 如果小于的话，就返回当前位置，跑步超过第二名还是第二名，所以不用减 1。
		else {
			return low;
		}
	}

	public static void main(String[] args) {
		// System.out.println(new SearchInsertPosition().searchInsert(nums,
		// target));
		System.out.println(new SearchInsertPosition().searchInsertHalfInterval(nums, target));
	}
}
