package com.road.LeeCode;

/**
 * @Describe 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 *           字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * @Author Road
 * @Date 2019/2/12 13:55
 **/
public class ImplementStrstr {
	static String haystack = "hello";
	static String needle = "o";

	/**
	 * 暴力匹配算法
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int implementStrFirst(String haystack, String needle) {
		int hayLen = haystack.length();
		int nedLen = needle.length();

		char[] hayArray = haystack.toCharArray();
		char[] nedArray = needle.toCharArray();

		int i = 0, j = 0;
		while (i < hayLen && j < nedLen) {
			if (hayArray[i] == nedArray[j]) {
				// 如果当前字符串匹配成功，则i++，j++
				i++;
				j++;
			} else {
				// 如果匹配失败（即S[i]!= P[j]）,令i = i - (j -1),j = 0
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == nedLen) {
			return i - j;
		} else {
			return -1;
		}
	}

	/**
	 * 先将haystack
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public String implementStr(String haystack, String needle) {
		if (needle.equals("")) {
			return haystack;
		}
		if (haystack.equals("")) {
			return null;
		}
		char[] arr = needle.toCharArray();
		// KMP算法
		int[] next = makeNext(arr);

		for (int i = 0, j = 0, end = haystack.length(); i < end;) {
			if (j == -1 || haystack.charAt(i) == arr[j]) {
				j++;
				i++;
				if (j == arr.length) {
					return haystack.substring(i - arr.length);
				}
			}
			if (i < end && haystack.charAt(i) != arr[j]) {
				j = next[j];
			}
		}
		return null;
	}

	private int[] makeNext(char[] arr) {
		int len = arr.length;
		int[] next = new int[len];

		next[0] = -1;
		for (int i = 0, j = -1; i + 1 < len;) {
			if (j == -1 || arr[i] == arr[j]) {
				next[i + 1] = j + 1;
				if (arr[i + 1] == arr[j + 1]) {
					next[i + 1] = next[j + 1];
					i++;
					j++;
				}
			}
			if (arr[i] != arr[j]) {
				j = next[j];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		// new ImplementStrstr().implementStr(haystack, needle);
		System.out.println(new ImplementStrstr().implementStrFirst(haystack, needle));
	}
}
