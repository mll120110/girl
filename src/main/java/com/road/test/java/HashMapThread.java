package com.road.test.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapThread extends Thread {

	private static AtomicInteger ai = new AtomicInteger(0);
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

	public void run() {
		while (ai.get() < 100000) {
			map.put(ai.get(), ai.get());
			ai.incrementAndGet();
		}
	}

	public String run(int params) {
		return "ABC";
	}
}