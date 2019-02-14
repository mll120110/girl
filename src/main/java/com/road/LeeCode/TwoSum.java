package com.road.LeeCode;

/**
 * @Describe 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 给定
 *           nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 =
 *           9,所以返回 [0, 1]
 * @Author Road
 * @Date 2019/2/13 16:54
 **/
public class TwoSum {
	static int[] nums = { 2, 5, 5, 11 };
	static int tatget = 10;

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

	public static void main(String[] args) {
		new TwoSum().twoSumFirst(nums, tatget);
	}
}
