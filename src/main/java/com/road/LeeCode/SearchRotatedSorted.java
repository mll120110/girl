package com.road.LeeCode;

/**
 * @Describe 假设按照升序排序的数组在预先未知的某个点上进行了旋转。 使用二分法
 * @Author Road
 * @Date 2019/3/8 14:35
 **/
public class SearchRotatedSorted {
    /**
     * 思路：nums为有序，分2半
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

	/**
	 * 思路，将有序数组分为2部分，
	 * @param nums
	 * @param target
	 * @return
	 */
	public int secondTest(int[] nums, int target) {

        return -1;
    }
}
