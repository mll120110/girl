package com.road.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.road.test.java.HashMapThread;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	@Test
	public void TestHashCode() {
		/**
		 * hashcode计算
		 */
		int h = 0, hash;
		char[] value = { 'h', 'a', 's', 'h', 'C', 'o', 'd', 'e' };
		if (h == 0 && value.length > 0) {
			char val[] = value;
			for (int i = 0; i < value.length; i++) {
				System.out.println("val " + i + " " + val[i]);
				System.out.println("acsoll码 " + val[i]);
				h = 31 * h + val[i];
				System.out.println("h " + h);
			}
			hash = h;
			System.out.println("hash值 " + hash);
			System.out.println("hash值转为二进制 " + Integer.toBinaryString(hash));
			System.out.println("hash值位运算 " + Integer.toBinaryString(hash >>> 16));
		}
	}

	@Test
	public void TestHashMapDeadLock() {
		/**
		 * 实现hashmap死锁场景
		 */
		HashMapThread hashMapThread0 = new HashMapThread();
		HashMapThread hashMapThread1 = new HashMapThread();
		HashMapThread hashMapThread2 = new HashMapThread();
		HashMapThread hashMapThread3 = new HashMapThread();
		HashMapThread hashMapThread4 = new HashMapThread();
		hashMapThread0.start();
		hashMapThread1.start();
		hashMapThread2.start();
		hashMapThread3.start();
		hashMapThread4.start();
	}

	@Test
	public void TestForEach() {
		int arry[][] = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 9 } };
		boolean found = false;
		for (int i = 0; i < arry.length && !found; i++) {
			for (int j = 0; j < arry[i].length; j++) {
				System.out.println("i=" + i + ",j=" + j);
				System.out.println("val: " + arry[i][j]);
				if (arry[i][j] == 2) {
					found = true;
					break;
				}
			}
		}
	}

	@Test
	public void TestForEatch1() {
		short sh = 1;
		sh = (short) (sh + 1);
		sh += 1;

		char aa = '汗';
		System.out.println(aa);

		int i;
		for (int j = 50; j < 150; j++) {
			if (j % 5 == 0) {
				System.out.println("\n");
				continue;
			}
			System.out.println(j);
		}
		System.out.println("\n");

		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int sum = a + b;
		System.out.println("a+b: " + sum);

	}

	@Test
	public void testToAlias() {
		int a = 0;
		if (false) {
			a = 1;
			System.out.println(a);
		} else if (true) {
			a = 2;
			System.out.println(a);
		} else if (true) {
			a = 3;
			System.out.println(a);
		}
	}

	/**
	 * 冒泡排序算法，简单实践
	 */
	@Test
	public void testBubbleSort() {
		int a[] = new int[] { 9, 12, 13, 28, 43 };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int value = a[j];
					a[j] = a[j + 1];
					a[j + 1] = value;
				}
			}
		}
	}

}
