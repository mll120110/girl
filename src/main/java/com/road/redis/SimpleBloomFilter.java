package com.road.redis;

import java.util.BitSet;

/*
	布隆算法：
	1、先声明全为0的bitSet数组
	2、设置seed为6的hash函数
	3、将数据经过6次Hash函数的计算放置bitSet数组
 */
public class SimpleBloomFilter {
	private static final int DEFAULT_SIZE = 2 << 24;
	private static final int[] seed = new int[] { 7, 11, 13, 31, 37, 61 };

	private BitSet bits = new BitSet(DEFAULT_SIZE);
	private SimpleHash[] func = new SimpleHash[seed.length];

	public static void main(String[] args) {
		String value = " stone2083@yahoo.cn ";
		SimpleBloomFilter filter = new SimpleBloomFilter();
		System.out.println("初始化是否包含：" + filter.contains(value));
		filter.add(value);
		System.out.println("打印输出：" + filter.contains(value));
	}

	public SimpleBloomFilter() {
		for (int i = 0; i < seed.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seed[i]);
		}
	}

	private void add(String value) {
		for (SimpleHash f : func) {
			bits.set(f.hash(value), true);
		}
	}

	private boolean contains(String value) {
		if (value == null) {
			return false;
		}
		boolean ret = true;
		for (SimpleHash f : func) {
			System.out.println("SimpleHash+hash值" + f.hash(value));
			System.out.println("bits:" + bits.get(f.hash(value)));
			ret = ret && bits.get(f.hash(value));
			System.out.println("到底是什么值：" + ret);
		}
		return ret;
	}

}
