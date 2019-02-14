package com.road.LeeCode;

/**
 * @Describe 两个有序数组，求两个数组中位数，A:{1,2,3}, B:{4,5},A,B数组中位数为3
 * @Author Road
 * @Date 2019/2/14 9:47
 **/
public class MedianTwoSortedArrays {
	static int[] nums1 = { 4, 5 };
	static int[] nums2 = { 1, 2, 3 };

	public double findMedianSortedArrays(int[] A, int[] B) {
		// 第一个整数数组
		int m = A.length;
		// 第二个整数数组
		int n = B.length;
		// 若第一个数组长度大于第二个长度，A,B数组互换(长度短的数组在A)
		if (m > n) {
			int[] temp = A;
			A = B;
			B = temp;

			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				// i is too small
				iMin = i + 1;
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1;
			}
			// i is perfect
			else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}

				if ((m + n) % 2 == 1) {
					System.out.println(maxLeft);
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}
				System.out.println((maxLeft + minRight) / 2.0);
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public static void main(String[] args) {
		new MedianTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
	}
}
