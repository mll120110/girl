package com.road.test.java;

public class Child {
	private static final int CAPACITY = 1024;

	public Child() {
		this(CAPACITY);
	}

	private Child(int capacity) {
		System.out.println(capacity);
	}

}
