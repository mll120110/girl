package com.road.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * 引用google 布隆jar包，简单使用
 */
public class TestBloomFilter {
	private static int size = 100000000;

	private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size);

	public static void main(String[] args) {
		for (int i = 0; i < size; i++) {
			bloomFilter.put(i);
		}

		for (int i = 0; i < size; i++) {
			if (!bloomFilter.mightContain(i)) {
				System.out.println("有数据逃脱");
			}
		}

		List<Integer> list = new ArrayList<Integer>(1000);
		for (int i = size + 1000; i < size + 2000; i++) {
			if (bloomFilter.mightContain(i)) {
				list.add(i);
			}
		}

		System.out.println("有数据误伤呐：" + list.size());
	}
}
