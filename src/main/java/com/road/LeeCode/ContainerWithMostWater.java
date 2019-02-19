package com.road.LeeCode;

/**
 * @Describe 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea
 *           来持续存储到目前为止所获得的最大面积。 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新
 *           maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
 * @Author Road
 * @Date 2019/2/14 16:57
 **/
public class ContainerWithMostWater {
	static int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

	public int pairPointerMaxArea(int[] height) {
		int i = 0, j = height.length - 1, res = 0;
		while (i < j) {
			// 左右两侧数取最小
			int h = Math.min(height[i], height[j]);
			res = Math.max(res, h * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}

	public int maxArea(int[] height) {
		int resArea = 0;
		int tempResArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {

				// 若左侧小于右侧，按照左侧进行计算
				if (height[i] <= height[j]) {
					tempResArea = height[i] * (j - i);
				}
				// 根据右侧计算面积
				else {
					tempResArea = height[j] * (j - i);
				}
				if (resArea < tempResArea) {
					resArea = tempResArea;
				}
			}
		}
		System.out.println(resArea);
		return resArea;
	}

	public static void main(String[] args) {
		new ContainerWithMostWater().maxArea(nums);
	}
}
